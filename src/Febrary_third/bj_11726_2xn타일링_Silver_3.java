package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_11726_2xn타일링_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[]dp = new int[N+1];
        if(N<=2) {
            System.out.println(N);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<N+1;i++) dp[i] = (dp[i-1] + dp[i-2] % 10007);

        System.out.println(dp[N]);

    }
}