package Algorithm_fifth_week_2023_07.st;

import java.io.*;
import java.util.*;

public class st_징검다리_Level_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]dp = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = 0;
        for(int i=0;i<N;i++){
            int num = arr[i];
            for(int j=0;j<=i;j++){
                if(arr[j]<num){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        for(int i=0;i<N;i++) max = Math.max(max,dp[i]);
        System.out.println(max);

    }
}
