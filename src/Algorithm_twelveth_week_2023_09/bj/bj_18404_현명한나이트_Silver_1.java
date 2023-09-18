package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_18404_현명한나이트_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        StringBuilder sb = new StringBuilder();
        int[][]dist = new int[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x,0});
        int[][]move = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
        boolean[][]visited = new boolean[N][N];
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            dist[i][j] = cnt;
            for(int d=0;d<8;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }

        for(int c=0;c<M;c++){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            sb.append(dist[i][j]+"\n");
        }
        System.out.println(sb.toString());


    }
}
