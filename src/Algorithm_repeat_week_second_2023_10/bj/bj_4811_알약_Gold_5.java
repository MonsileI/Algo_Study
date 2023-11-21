package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_4811_알약_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[]dp = new long[31];
        dp[1] = 1;
        dp[2] = 2;
        long num = 3;
        int gop = 3;
        for(int i=3;i<31;i++) {
            dp[i] = dp[i-1] + num;
            num *= gop;
            gop++;
        }
        StringBuilder sb= new StringBuilder();
        while(true){
            int number = Integer.parseInt(br.readLine());
            if(number==0) break;
            sb.append(dp[number]+"\n");
        }
        System.out.println(sb.toString());
    }
}
