package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1890_점프_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]map = new int[N+1][N+1];
        long[][]dp = new long[N+1][N+1];
        StringTokenizer st = null;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                int ni = i + map[i][j];
                int nj = j + map[i][j];
                if(map[i][j]==0) break;
                if(ni<N+1) dp[ni][j] += dp[i][j];
                if(nj<N+1) dp[i][nj] += dp[i][j];
            }
        }
        System.out.println(dp[N][N]);
    }
}
