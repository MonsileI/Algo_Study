package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1245_산봉우리_Gold_5 {
    static int N,M,map[][];
    static boolean[][]visited;

    static int cnt;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&1<map[i][j]){
                    bfs(i,j,map[i][j]);

                }
            }
        }
        System.out.println(cnt);
    }
    static void bfs(int y,int x,int high){
        int max = 0;
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x,high});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int h = c[2];
            max = Math.max(max,h);
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&1<map[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,map[ni][nj]});
                }
            }
        }
        boolean[][]visited2 = new boolean[N][M];
        q = new ArrayDeque<>();
        q.offer(new int[]{y,x,high});
        visited2[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int h = c[2];
            if(h==max) cnt++;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited2[ni][nj]&&1<map[ni][nj]){
                    visited2[ni][nj] = true;
                    if(map[ni][nj]==max&&h==max) cnt--;
                    q.offer(new int[]{ni,nj,map[ni][nj]});
                }
            }
        }
    }
}
