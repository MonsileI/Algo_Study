package Algorithm_eighth_week_2023_08.gr;
import java.util.*;
import java.io.*;
public class gr_징검다리건너기_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+3];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=3;i<N+3;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N+3];
        for(int i=3;i<N+3;i++){
            dp[i] = Math.min(Math.min(dp[i-1],dp[i-2]),dp[i-3]) + arr[i];
        }
        System.out.println(Math.min(Math.min(dp[N],dp[N+1]),dp[N+2]));
    }
}
