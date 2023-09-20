package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_9625_BABBA_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        if(N==1){
            System.out.println(0+" "+1);
        }else if(N==2){
            System.out.println(1+" "+1);
        }
        else{
            dp[2] = 1;
            dp[3] = 2;
            for(int i=4;i<N+1;i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            System.out.println(dp[N-1]+" "+dp[N]);
        }
    }
}
