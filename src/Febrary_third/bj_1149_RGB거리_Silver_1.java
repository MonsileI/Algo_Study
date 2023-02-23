package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_1149_RGB거리_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]dp = new int[N+1][3];

        StringTokenizer st = null;

        for(int i=1;i<=N;i++){

            st= new StringTokenizer(br.readLine()," ");

            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + R;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + G;
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + B;

        }

        System.out.println(Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2])));
    }
}
