package March_Second;

import java.util.*;
import java.io.*;
public class bj_12865_평범한배낭_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][]dp = new int[N+1][K+1]; //물건  //무게
        int[]W = new int[N+1];
        int[]V = new int[K+1];

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<K+1;j++){
                dp[i][j] = dp[i-1][j]; //전에꺼를 넣어줌(비교를 위해)
                if(W[i] < j+1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
