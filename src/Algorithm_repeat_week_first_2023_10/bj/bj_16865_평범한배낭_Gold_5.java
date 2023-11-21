package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_16865_평범한배낭_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int T = Integer.parseInt(st.nextToken());
        int []w = new int[N+1]; int[]v = new int[N+1];
        int[][]dp = new int[N+1][T+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            for(int j=0;j<T+1;j++){
                dp[i][j] = dp[i-1][j];
                if(w[i]<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[N][T]);
    }
}
