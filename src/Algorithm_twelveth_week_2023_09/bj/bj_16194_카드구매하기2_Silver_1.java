package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_16194_카드구매하기2_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[][]dp = new int[N+1][N+1];
        int INF = 987654321;
        for(int i=0;i<N+1;i++){
            for(int j=0;j<N+1;j++){
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;

        for(int i=1;i<N+1;i++){
            int w = arr[i]; int v = i;
            for(int j=0;j<N+1;j++){
                dp[i][j] = dp[i-1][j];
                if(v<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-v]+w);
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}
