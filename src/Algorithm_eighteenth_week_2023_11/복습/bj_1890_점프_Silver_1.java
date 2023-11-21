package Algorithm_eighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_1890_점프_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]map = new int[N][N];
        long[][]dp = new long[N][N];
        StringTokenizer  st=null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0) break;
                if(dp[i][j]==0) continue;
                int ni = i + map[i][j];
                int nj = j + map[i][j];
                if(ni<N) dp[ni][j] += dp[i][j];
                if(nj<N) dp[i][nj] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
