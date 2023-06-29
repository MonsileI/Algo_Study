package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_11052_카드구매하기_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]dp = new int[N+1];
        int[]p = new int[N+1];
        for(int i=1;i<N+1;i++) p[i] = Integer.parseInt(st.nextToken());

        for(int i=1;i<N+1;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]+p[j]);
            }
        }


        System.out.println(dp[N]);

    }
}
