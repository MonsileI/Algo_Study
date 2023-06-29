package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_9095_123더하기_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[]dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<12;i++) dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        StringBuilder sb= new StringBuilder();
        for(int t=0;t<T;t++){
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
