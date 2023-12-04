package kakao;

import java.util.Arrays;

public class no_5 {

    static int solution(int n, int[] tops) {
        int mod = 10007;
        long[]dp = new long[n];
        if(n==1){
            if(tops[0]==1) return 4;
            else return 3;
        }
        dp[0] = (tops[0]==0 ? 3 : 4);
        dp[1] = (tops[1]==0 ? dp[0]*3 - 1 : dp[0]*4 - 1);
        for(int i=2;i<n;i++){
            if (tops[i] == 0) dp[i] = ((dp[i-1]*3) - dp[i-2]) % mod;
            else  dp[i] = ((dp[i-1]*4) - dp[i-2]) % mod;
            if (dp[i]<0) dp[i] += mod;
        }

        return (int)(dp[n-1]%mod);
    }

    public static void main(String[] args) {
        int n = 10;
        int [] tops = {0,0,0,0,0,0,0,0,0,0};
        System.out.println(solution(n,tops));
    }
}
