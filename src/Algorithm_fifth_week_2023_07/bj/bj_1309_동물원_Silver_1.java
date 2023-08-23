package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_1309_동물원_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 3;
        int answer = 0;
        if(N==1) answer = 3;
        else{
            for(int i=2;i<N+1;i++){
                dp[i] = ((dp[i-1]*2) + dp[i-2]) % 9901;
            }
            answer = dp[N];
        }
        System.out.println(answer);
    }
}
