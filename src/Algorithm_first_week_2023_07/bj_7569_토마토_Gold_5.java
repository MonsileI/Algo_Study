package Algorithm_first_week_2023_07;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class bj_7569_토마토_Gold_5 {
    static int N,M,H;
    static int[][]map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N*H][M];
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1},{N+1,0},{-N-1,0}}; //아래일 경우 위에만 위에일 경우 아래만 중간일 경우 ㅇ둘다
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][]visited = new boolean[N*H][M];
        int cnt = 0;
        for(int i=0;i<N*H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }else if(map[i][j]==0) cnt++;
            }
        }

        int answer = 0;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int time = c[2];
            answer = time;
            for(int d=0;d<6;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N*H-1<ni||M-1<nj) continue;
                if(map[ni][nj]==0&&!visited[ni][nj]){
                    visited[ni][nj] = true;
                    map[ni][nj] = 1;
                    cnt--;
                    q.offer(new int[]{ni,nj,time+1});
                }
            }
            for(int a=0;a<N*H;a++){
                for(int b=0;b<M;b++){
                    System.out.print(map[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println("===========");

        }
        for(int i=0;i<N*H;i++) for(int j=0;j<M;j++){if(map[i][j]==0) answer = -1; break;}
        System.out.println(answer);
    }
}
