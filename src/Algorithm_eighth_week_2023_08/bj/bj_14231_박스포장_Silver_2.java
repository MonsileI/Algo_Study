package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_14231_박스포장_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        int[]arr = new int[N+1];
        StringTokenizer st =  new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = 0;
        for(int i=1;i<N+1;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);

    }
}
