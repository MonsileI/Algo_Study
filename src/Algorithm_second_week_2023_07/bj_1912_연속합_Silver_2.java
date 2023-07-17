package Algorithm_second_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1912_연속합_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        int[]dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] =  Integer.parseInt(st.nextToken());
        dp[0] = arr[0];
        int answer = arr[0];
        for(int i=1;i<N;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            answer = Math.max(answer,dp[i]);
        }

        System.out.println(answer);
    }
}
