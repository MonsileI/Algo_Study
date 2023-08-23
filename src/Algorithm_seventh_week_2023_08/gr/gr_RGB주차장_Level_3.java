package Algorithm_seventh_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_RGB주차장_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i=2;i<N+1;i++){
            dp[i] = (dp[i-1]*2)%1000000007;
        }
        System.out.println(dp[N]);
    }
}
