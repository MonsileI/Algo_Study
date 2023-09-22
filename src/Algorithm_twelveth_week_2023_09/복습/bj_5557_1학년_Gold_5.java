package Algorithm_twelveth_week_2023_09.복습;

import java.util.*;
import java.io.*;
public class bj_5557_1학년_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        long[][]dp = new long[N-1][21];
        dp[0][arr[0]] = 1;
        for(int i=1;i<N-1;i++){
            for(int j=0;j<21;j++){
                if(j-arr[i]>-1) dp[i][j] += dp[i-1][j-arr[i]];
                if(j+arr[i]<21) dp[i][j] += dp[i-1][j+arr[i]];
            }
        }
        System.out.println(dp[N-2][arr[N-1]]);
    }
}
