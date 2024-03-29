package Algorithm_seventeenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_1149_RGB거리_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]dp = new int[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+a;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+b;
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+c;
        }
        System.out.println(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));
    }
}
