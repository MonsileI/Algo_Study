package Algorithm_fourth_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_11055_가장큰증가하는부분수열_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        int answer = 0;
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N];
        dp[0] = arr[0];
        int max =arr[0];
        for(int i=0;i<N;i++){
            dp[i] = arr[i];
           for(int j=0;j<i;j++){
               if(arr[j]<arr[i]){
                   dp[i] = Math.max(dp[i],dp[j]+arr[i]);
               }
           }
        }
        for(int i : dp) max = Math.max(max,i);
        System.out.println(max);

    }
}
