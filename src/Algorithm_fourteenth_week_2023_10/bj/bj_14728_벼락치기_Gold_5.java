package Algorithm_fourteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14728_벼락치기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Goal = Integer.parseInt(st.nextToken());
        int[]w = new int[N+1]; int []v = new int[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        int[][]dp = new int[N+1][Goal+1];
        for(int i=1;i<N+1;i++){
            int weight = w[i];
            int value = v[i];
            for(int j=0;j<Goal+1;j++){
                dp[i][j] = dp[i-1][j];
                if(weight<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-weight]+value);
                }
            }
        }
        System.out.println(dp[N][Goal]);
    }
}
