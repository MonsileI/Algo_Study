package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2156_포도주시식_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        if(N==1) System.out.println(arr[1]);
        else if(N==2) System.out.println(arr[1]+arr[2]);
        else{
            dp[1] = arr[1];
            dp[2] = arr[1]+arr[2];
            dp[3] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
            for(int i=3;i<N+1;i++){
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i-1] + arr[i]));
            }
            System.out.println(dp[N]);
        }

    }
}
