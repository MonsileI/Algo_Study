package April_Second;

import java.util.*;
import java.io.*;
public class bj_1012_유기농배추_Silver_2 {
    static int map[][],N,M,C;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int ti=0;ti<C;ti++){
                st = new StringTokenizer(br.readLine()," ");
                int j = Integer.parseInt(st.nextToken());
                int i = Integer.parseInt(st.nextToken());
                map[i][j] = 1;
            }
            int cnt = 0;
            for(int i=0;i<N;i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }


    static void bfs(int y, int x) {

        Queue<int[]> q  = new ArrayDeque<>();
        q.offer(new int[]{y,x});

        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0];
            int j = c[1];

            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(map[ni][nj]==1 && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }

            }

        }

    }
}
