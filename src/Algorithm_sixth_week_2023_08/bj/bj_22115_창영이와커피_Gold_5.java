package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_22115_창영이와커피_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr= new int[N+1];
        int answer = 1;
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for(int i=1;i<N+1;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        if(total<K) answer = -1;
        else{
            int[][]dp = new int[N+1][K+1];
            for(int i=1;i<N+1;i++){
                for(int j=1;j<K+1;j++){
                    dp[i][j] = 987654321;
                }
            }

            for(int i=1;i<N+1;i++){
                int num = arr[i];
                for(int j=1;j<K+1;j++){
                    if(dp[i-1][j]!=0) dp[i][j] = dp[i-1][j];
                    if(arr[i]<=j){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-arr[i]]+1);
                    }
                }
            }
            answer = (dp[N][K]==987654321) ? -1 : dp[N][K];
        }
        System.out.println(answer);   
    
    }
}
