package Algorithm_third_week_2023_07;

import java.io.*;
import java.util.*;
public class bj_16918_봄버맨_Silver_1 {
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M,T;
    static char[][]map;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='O')q.offer(new int[]{i,j});
            }
        }
        for(int t=2;t<T+1;t++){


            if(t%2==0){
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        map[i][j] = 'O';
                    }
                }
            }else{
                bomb();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bomb(){

        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            map[i][j] = '.';
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                map[ni][nj] = '.';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                if(map[i][j]=='O') q.offer(new int[]{i,j});
            }
        }

    }
}
