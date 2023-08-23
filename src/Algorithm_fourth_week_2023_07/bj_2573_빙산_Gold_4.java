package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;

public class bj_2573_빙산_Gold_4 {
    static int N,M,map[][];
    static Queue<int[]> q;
    static boolean[][]visited;
    static int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        q = new ArrayDeque<>();
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j,map[i][j]});
                }
            }
        }
        int time = 0;
        if(q.size()!=1) {
            OuterLoop:
            while(true){

                time++;
                while(!q.isEmpty()){
                    int [] c = q.poll();
                    int i = c[0]; int j = c[1];
                    for(int d=0;d<4;d++){
                        int ni = i + dir[d][0]; int nj = j + dir[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(map[ni][nj]==0&&!visited[ni][nj]) {
                            map[i][j]--;
                            if(map[i][j]<1) {map[i][j] = 0;continue;}
                        }
                    }
                }
                visited = new boolean[N][M];
                int cnt = 0;
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(map[i][j]!=0){
                            if(!visited[i][j]){
                                visited[i][j] = true;
                                bfs(i,j);
                                cnt++;
                            }
                            q.offer(new int[]{i,j});
                        }
                        if(1<cnt) break;
                    }
                }

                if(q.isEmpty()) {time = 0; break OuterLoop;}
            }
        }

        System.out.println(time);
    }
    static void bfs(int y,int x){

        Queue<int[]> tq = new ArrayDeque<>();
        tq.offer(new int[]{y,x});
        while(!tq.isEmpty()){
            int[]c = tq.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + dir[d][0]; int nj = j + dir[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]!=0 && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }

    }
}


