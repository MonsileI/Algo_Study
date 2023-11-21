package Algorithmeighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_2096_내려가기_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][]dp = new int[N][3];
        int[][]dp2 = new int[N][3];
        dp[0][0] = dp2[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = dp2[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = dp2[0][2] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){

            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])+a;
            dp[i][1] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]))+b;
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2])+c;

            dp2[i][0] = Math.min(dp2[i-1][0],dp2[i-1][1])+a;
            dp2[i][1] = Math.min(dp2[i-1][0],Math.min(dp2[i-1][1],dp2[i-1][2]))+b;
            dp2[i][2] = Math.min(dp2[i-1][1],dp2[i-1][2])+c;

        }
        System.out.print(Math.max(dp[N-1][0],Math.max(dp[N-1][1],dp[N-1][2]))+" ");
        System.out.println(Math.min(dp2[N-1][0],Math.min(dp2[N-1][1],dp2[N-1][2])));
    }
}
