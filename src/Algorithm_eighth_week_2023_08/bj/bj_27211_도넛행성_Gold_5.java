package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_27211_도넛행성_Gold_5 {
    static int N,M,map[][];
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int answer = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&map[i][j]==0){
                    bfs(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i  + move[d][0]; int nj=  j + move[d][1];
                if(ni<0) ni = N-1;
                if(nj<0) nj = M-1;
                if(N-1<ni) ni = 0;
                if(M-1<nj) nj = 0;
                if(!visited[ni][nj]&& map[ni][nj] == 0){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
