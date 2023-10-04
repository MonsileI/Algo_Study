package Algorithm_thirteenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_4781_사탕가게_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            double tmp = Double.parseDouble(st.nextToken());
            if(N==0&&tmp==0.00) break;

            int b = (int)(tmp*100+0.5);
            int[][]dp = new int[N+1][b+1];
            int []v = new int[N+1];
            int []w = new int[N+1];
            for(int i=1;i<N+1;i++){
                st = new StringTokenizer(br.readLine()," ");
                v[i] = Integer.parseInt(st.nextToken());
                tmp = Double.parseDouble(st.nextToken());
                w[i] = (int)(tmp*100+0.5);
            }
            for(int i=1;i<N+1;i++){
                for(int j=1;j<=b;j++){
                    dp[i][j] = dp[i-1][j];
                    if(w[i]<=j){
                        dp[i][j] = Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                    }
                }
            }
            sb.append(dp[N][b]+"\n");
        }
        System.out.println(sb.toString());
    }
}
