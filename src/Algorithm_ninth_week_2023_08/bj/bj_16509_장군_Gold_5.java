package Algorithm_ninth_week_2023_08.bj;

import java.io.*;
import java.util.*;

public class bj_16509_장군_Gold_5 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=10;
        int M=9;
       /*
        int[][]moveF = {{-1,0},{0,1},{1,0},{0,-1}};
        int[][]moveS = {{-1,-1},{-1,1},{-1,1},{1,1},{1,1},{1,-1},{1,-1},{-1,-1}};
        */
        int[][][]move = {{{-1,0},{-1,-1},{-1,-1}},{{-1,0},{-1,1},{-1,1}},{{0,1},{-1,1},{-1,1}},{{0,1},{1,1},{1,1}},
                        {{1,0},{1,1},{1,1}},{{1,0},{1,-1},{1,-1}},{{0,-1},{1,-1},{1,-1}},{{0,-1},{-1,-1},{-1,-1}}};


        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int ki = Integer.parseInt(st.nextToken());
        int kj = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][]visited = new boolean[N][M];
        visited[si][sj] = true;
        q.offer(new int[]{si,sj,0});
        int answer = -1;
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==ki&&j==kj){
                answer = cnt;
                break;
            }
            OuterLoop:
            for(int d=0;d<8;d++){
               int ni = i + move[d][0][0]; int nj = j + move[d][0][1];
               if(ni<0||nj<0||N-1<ni||M-1<nj||(ni==ki&&nj==kj)) continue;
               ni += move[d][1][0]; nj += move[d][1][1];
               if(ni<0||nj<0||N-1<ni||M-1<nj||(ni==ki&&nj==kj)) continue;
               ni += move[d][1][0]; nj += move[d][1][1];
               if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
               if(!visited[ni][nj]){
                   visited[ni][nj] = true;
                   q.offer(new int[]{ni,nj,cnt+1});
               }

            }
        }
        System.out.println(answer);
    }
}
