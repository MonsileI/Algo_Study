package Algorithm_second_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1912_연속합_Silver_2_re {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr =new  int[N];
        int [] dp = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = dp[0] = arr[0];
        for(int i=1;i<N;i++){
            if(arr[i]+dp[i-1]>=arr[i]) dp[i] = arr[i]+dp[i-1];
            else dp[i] = arr[i];
           max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
