package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_3067_coins_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[N+1];
            for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(br.readLine());
            int[][]dp = new int[N+1][G+1];
            for(int i=0;i<N+1;i++)dp[i][0] = 1;
            for(int i=1;i<N+1;i++){
                int coin = arr[i];
                for(int j=0;j<G+1;j++){
                    dp[i][j] = dp[i-1][j];
                    if(coin<=j){
                        dp[i][j] += dp[i][j-coin];
                    }
                }
            }
            sb.append(dp[N][G]+"\n");
        }
        System.out.println(sb.toString());
    }
}
