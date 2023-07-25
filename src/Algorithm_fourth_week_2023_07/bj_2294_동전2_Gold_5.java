package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2294_동전2_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(br.readLine());
        int answer = 0;
        int[]dp = new int[K+1];
        Arrays.fill(dp,987654321);
        dp[0] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=arr[i];j<K+1;j++){
                dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }

        System.out.println(dp[K]==987654321 ? -1 : dp[K]);
    }
}
