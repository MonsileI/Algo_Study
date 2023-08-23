package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_11053_가장긴증가하는부분수열_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N];
        Arrays.fill(dp,1);

        int answer = 0;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            answer = Math.max(answer,dp[i]);
        }
        if(answer==0)answer=1;
        System.out.println(answer);
    }
}
