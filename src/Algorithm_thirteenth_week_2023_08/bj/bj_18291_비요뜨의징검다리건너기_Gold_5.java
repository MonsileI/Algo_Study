package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_18291_비요뜨의징검다리건너기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<a;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            if (N == 0) sb.append(1 + "\n");
            else {
                dp[1] = 1;
                for (int i = 2; i < N + 1; i++) dp[i] = dp[i - 1] * 2 ;
                sb.append(dp[N] + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
