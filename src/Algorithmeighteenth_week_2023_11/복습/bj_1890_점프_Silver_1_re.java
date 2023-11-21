package Algorithmeighteenth_week_2023_11.복습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1890_점프_Silver_1_re {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        int[][]map = new int[N][N];
        long[][]dp = new long[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(dp[i][j]==0) continue;
                if(map[i][j]==0) break OuterLoop;
                int ni = i + map[i][j]; int nj= j + map[i][j];
                if(ni<N) dp[ni][j] += dp[i][j];
                if(nj<N) dp[i][nj] += dp[i][j];
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}