package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_17404_RGB거리2_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]dp = new int[N+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        int []check = new int [3];
        StringTokenizer st = null;
        int[][]arr = new int[N+1][3];

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i][0] = R;
            arr[i][1] = G;
            arr[i][2] = B;
        }
        int answer = 987654321;

        for(int start=0;start<3;start++){
            for(int k=0;k<3;k++) {

                if (start == k) dp[1][k] = arr[1][k];
                else dp[1][k] = 987654321;
            }
                for(int i=2;i<N+1;i++){
                    dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][0];
                    dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + arr[i][1];
                    dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
                }
            for(int i=0;i<3;i++){
                if(start!=i) answer = Math.min(answer,dp[N][i]);
            }
        }

        System.out.println(answer);

    }
}
