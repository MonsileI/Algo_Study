package March_Third;

import java.util.*;
import java.io.*;
public class bj_1003_피보나치함수_Silver_3 {
    static int[][]dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][]dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=0;i<N;i++){


            int num = Integer.parseInt(br.readLine());
            for(int k=2;k<num+1;k++){
                dp[k][0] = dp[k-1][0] + dp[k-2][0];
                dp[k][1] = dp[k-1][1] + dp[k-2][1];
            }
            sb.append(dp[num][0]+" "+dp[num][1]).append("\n");
        }

        System.out.println(sb.toString());

    }

}
