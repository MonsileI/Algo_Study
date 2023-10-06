package Algorithm_foureenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_10422_괄호_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[]dp = new long[5001];
        dp[0] = 1; dp[2] = 1;
        for(int i=2; i<2501; i++) {
            for (int j = 0; j < i; j++) {
                dp[i * 2] += (dp[j * 2] * dp[(i - 1 - j) * 2]);
                dp[i * 2] %= 1000000007L;
            }
        }
        for(int t=0;t<TC;t++){
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]+"\n");
        }
        System.out.println(sb.toString());
    }
}
