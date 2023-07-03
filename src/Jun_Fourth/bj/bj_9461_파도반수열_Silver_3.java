package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_9461_파도반수열_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            if(N<4){
                sb.append(1).append("\n");
                continue;
            }
            long[]dp = new long[N+1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for(int i=3;i<N+1;i++) dp[i] = dp[i-2] + dp[i-3];
            sb.append(dp[N-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
