package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_3055_탈출_Gold_4 {
    static int N, M;
    static char[][] map;
    static Queue<int[]> q = new ArrayDeque<>();
    static Queue<int[]> rq = new ArrayDeque<>();
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int answer;

    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
                if(ch=='S') q.offer(new int[]{i,j,1});
                else if(ch=='*') rq.offer(new int[]{i,j});
            }
        }
        answer = 987654321;
        bfs();
        System.out.println(answer == 987654321 ? "KAKTUS" : answer);
    }
    static void bfs(){

        while(!q.isEmpty()){
            //비 퍼뜨림
            int len = rq.size();
            for(int t=0;t<len;t++){
                int []c = rq.poll();
                int i = c[0]; int j = c[1];
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0]; int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(map[ni][nj]=='.'){
                        map[ni][nj] = '*';
                        rq.offer(new int[]{ni,nj});
                    }
                }
            }
            len = q.size();
            for(int t=0;t<len;t++){
                int[]c = q.poll();
                int i = c[0]; int j = c[1]; int time = c[2];
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0]; int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(map[ni][nj]=='D'){
                        answer = time;
                        return;
                    }
                    if(map[ni][nj]=='.'){
                        map[ni][nj] ='S';
                        q.offer(new int[]{ni,nj,time+1});
                    }
                }

            }
        }

    }
}