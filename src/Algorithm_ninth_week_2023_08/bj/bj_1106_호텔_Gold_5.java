package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1106_호텔_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[]money = new int[N+1];
        int[]people = new int[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            money[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }
        int[][]dp = new int[N+1][C+1];
        int INF = 987654321;
        for(int i=0;i<C+1;i++) dp[0][i] = INF;
        dp[0][0] = 0;
        //적어도 C명이 포인트인데...
        for(int i=1;i<N+1;i++){
            int p = people[i];
            int m = money[i];
            for(int j=0;j<=C;j++){
                dp[i][j] = dp[i-1][j];
                if(p<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-p]+m);
                }
            }
        }
        for(int i=1;i<N+1;i++){
            int check = C%people[i];
            dp[N][C] = Math.min(dp[N][C],dp[N][C-check]+money[i]);
        }
        for(int i=0;i<N+1;i++){
            for(int j=0;j<C+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
