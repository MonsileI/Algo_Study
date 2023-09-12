package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_29704_벼락치기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N =Integer.parseInt(st.nextToken()); //문제개수
        int T = Integer.parseInt(st.nextToken()); //풀 수 있는 날 수
        int[]w = new int[N+1]; //무게
        int[]t = new int[N+1]; //벌칙 금액
        int max = 0;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st.nextToken());
            max += t[i];
        }
        int[][]dp = new int[N+1][T+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<T+1;j++){
                dp[i][j] = max;
            }
        }


        for(int i=1;i<N+1;i++){
            int day = w[i];
            int money = t[i];
            for(int j=0;j<T+1;j++){
                dp[i][j] = dp[i-1][j];
                if(day<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-day]-money);
                }
            }
        }
        System.out.println(-1<dp[N][T] ? dp[N][T] : 0);
    }
}
