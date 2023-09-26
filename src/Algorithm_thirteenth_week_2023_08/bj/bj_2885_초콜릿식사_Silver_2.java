package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2885_초콜릿식사_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[]dp = new long[1000001];
        dp[0] = 1;
        dp[1] = 1;
        long ans = 0;
        for(int i=2;i<1000001;i++) {
            dp[i] = dp[i-1]*2;
            if(N<=dp[i]) {
                ans = dp[i];
                break;
            }
        }
        long ans2 = 0;
        if(N==ans) System.out.println(ans+" 0");
        else{
            long namuzi = ans - N;
            long tmp = ans/2;
            ans2 = 1;
            while(true){
                if(namuzi%tmp==0) break;
                tmp /= 2;
                ans2++;
            }
            System.out.println(ans+" "+ans2);
        }
    }
}
