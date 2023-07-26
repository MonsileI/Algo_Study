package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_9465_스티커_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]map = new int[2][N+1];
            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<N+1;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(N==1){
                sb.append(0).append("\n");
                continue;
            }
            int[][]dp = new int[2][N+1];
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for(int i=2;i<N+1;i++){
               dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + map[0][i];
               dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + map[1][i];

            }

            sb.append(Math.max(dp[0][N],dp[1][N])).append("\n");

        }
        System.out.println(sb.toString());
    }
}
