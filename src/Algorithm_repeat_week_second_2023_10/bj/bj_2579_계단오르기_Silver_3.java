package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2579_계단오르기_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(br.readLine());

        dp[1] = arr[1];
        if (N >= 2) dp[2] = arr[1] + arr[2];
        for(int i=3;i<N+1;i++) dp[i] = Math.max(arr[i-1]+dp[i-3],dp[i-2])+arr[i];
        System.out.println(dp[N]);

    }

}
