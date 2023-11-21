package Algorithm_fourteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_21938_영상처리_Silver_2 {
    static int N,M;
    static int map[][];
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M*3];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int avg = 0;
                int f= Integer.parseInt(st.nextToken());
                int s= Integer.parseInt(st.nextToken());
                int t= Integer.parseInt(st.nextToken());
                avg = (f+s+t)/3;
                map[i][j] = avg;
                map[i][j+1] = avg;
                map[i][j+2] = avg;
            }
        }
        int num = Integer.parseInt(br.readLine());
        M *= 3;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]<num) map[i][j] = 0;
                else map[i][j] = 255;
            }
        }
        int answer=  0;

        visited=  new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==255&&!visited[i][j]){
                    answer++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
    static void bfs(int y,int x){
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i +move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==255){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
         }
    }
}
