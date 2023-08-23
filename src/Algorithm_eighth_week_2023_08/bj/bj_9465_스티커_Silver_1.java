package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_9465_스티커_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]arr = new int[2][N+2];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=2;i<N+2;i++) arr[0][i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=2;i<N+2;i++) arr[1][i] = Integer.parseInt(st.nextToken());
            int[][]dp = new int[2][N+2];
            for(int i=2;i<N+2;i++){
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + arr[1][i];
            }
            sb.append(Math.max(dp[0][N+1],dp[1][N+1])+"\n");
        }
        System.out.println(sb.toString());
    }
}
