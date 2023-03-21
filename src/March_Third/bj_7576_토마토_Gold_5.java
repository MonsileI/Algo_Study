package March_Third;

import java.util.*;
import java.io.*;
public class bj_7576_토마토_Gold_5 {

    static int answer,N,M,map[][];
    static boolean[][]visited;
    static int move[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    static int count;

    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        answer = 0;
        count = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i,j,0});
                }else if(map[i][j]==0) count++;
            }
        }
        bfs();

        System.out.println(count==0 ? answer : -1);

    }


    static void bfs() {

        while(!q.isEmpty()){

            int[]c = q.poll();
            int i = c[0];
            int j = c[1];
            int cnt = c[2];

            answer = cnt;

            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]==0){
                    count--;
                    map[ni][nj] = 1;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }

    }
}
