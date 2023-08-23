package Algorithm_sixth_week_2023_08.dp;

import java.util.*;
import java.io.*;
public class bj_22115_창영이와커피_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][]dp = new int[N+1][K+1];
        int[]arr = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=1;i<N+1;i++){
            for(int j=1;j<K+1;j++){
                dp[i][j] = 0;
            }
        }
        for(int i=1;i<K+1;i++) dp[0][i] = 987654321;

        for(int i=1;i<N+1;i++){
            int coffee = arr[i];
            for(int j=1;j<K+1;j++){
                dp[i][j] = dp[i-1][j];
                if(coffee<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-coffee]+1);
                }
            }
        }

        System.out.println(dp[N][K]==987654321 ? -1 : dp[N][K]);


    }
}
