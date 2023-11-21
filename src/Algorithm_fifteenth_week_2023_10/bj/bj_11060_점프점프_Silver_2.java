package Algorithm_fifteenth_week_2023_10.bj;

import java.io.*;
import java.util.*;

public class bj_11060_점프점프_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N+1];
        int INF = 987654321;
        Arrays.fill(dp,INF);
        dp[1] = 0;
        for(int i=1;i<N+1;i++){
            //나자신까지
            if(arr[i]==0||dp[i]==INF) continue;
            for(int j=i+1;j<=arr[i]+i;j++){
                if(j<N+1){
                dp[j] = Math.min(dp[j],dp[i]+1);
                }
            }
        }
        System.out.println(dp[N]==INF ? -1 : dp[N]);
    }
}
