package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_9084_동전_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[]arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(br.readLine());
            int[]dp = new int[target+1];
            dp[0] = 1;
            for(int i=0;i<N;i++){
                for(int j=arr[i];j<target+1;j++){
                    dp[j] += dp[j - arr[i]];
                }
                System.out.println(Arrays.toString(dp));
            }

            sb.append(dp[target]+"\n");
        }
        System.out.println(sb.toString());
    }
}
