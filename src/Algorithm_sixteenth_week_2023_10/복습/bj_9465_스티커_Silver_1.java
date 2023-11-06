package Algorithm_sixteenth_week_2023_10.복습;
import java.util.*;
import java.io.*;
public class bj_9465_스티커_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]arr = new int[N+1][2];
            int[][]dp = new int[N+1][2];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<N+1;i++) arr[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<N+1;i++) arr[i][1] = Integer.parseInt(st.nextToken());
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];
            for(int i=2;i<N+1;i++){
                dp[i][0] = Math.max(dp[i-1][1],dp[i-2][1])+arr[i][0];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-2][0])+arr[i][1];
            }
            sb.append(Math.max(dp[N][0],dp[N][1])+"\n");
        }
        System.out.println(sb.toString());
    }
}
