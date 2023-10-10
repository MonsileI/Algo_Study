package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1912_연속합_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []dp = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        //연속된 수
        dp[0] = arr[0];
        int max = arr[0];
        for(int i=1;i<N;i++) {
            if(dp[i-1]+arr[i]<arr[i]) dp[i] = arr[i];
            else dp[i] = dp[i-1]+arr[i];
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
