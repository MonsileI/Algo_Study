package Algorithm_sixth_week_2023_08.bj;

import java.io.*;
import java.util.*;

public class bj_22115_창영이와커피_Gold_5_re {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N+1];
        int[][]dp = new int[N+1][K+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N+1;i++){
            for(int j=0;j<K+1;j++) {
                dp[i][j] = 987654321;
            }
        }
        for(int i=0;i<N+1;i++) dp[i][0] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<K+1;j++){
                if(j-arr[i]<0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-arr[i]]+1);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int answer = dp[N][K] == 987654321 ? -1 : dp[N][K];
        System.out.println(answer);
    }
}
