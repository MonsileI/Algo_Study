package Algorithm_twenty_week_2023_12.bj;
import java.util.*;
import java.io.*;
public class bj_10844_쉬운계단수_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][]dp = new long[N+1][10];
        long mod = 1000000000;
        for(int i=1;i<10;i++) dp[1][i] = 1;

        for(int i=2;i<N+1;i++){
            for(int j=0;j<10;j++){
                if(j==0) dp[i][0] = dp[i-1][1] % mod;
                else if(j==9) dp[i][9] = dp[i-1][8] % mod;
                else{
                    dp[i][j] = (dp[i-1][j-1]  + dp[i-1][j+1]) % mod;
                }
            }
        }

        long result = 0;
        for(int i=0;i<10;i++) result += dp[N][i];
        System.out.println(result % mod);
    }
}
