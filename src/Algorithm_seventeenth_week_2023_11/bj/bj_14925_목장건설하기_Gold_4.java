package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_14925_목장건설하기_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][]dp = new int[N+1][M+1];
        int max = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i-1][j-1]>0) continue;
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
