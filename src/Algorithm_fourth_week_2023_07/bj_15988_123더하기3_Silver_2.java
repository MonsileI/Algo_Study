    package Algorithm_fourth_week_2023_07;

    import java.util.*;
    import java.io.*;
    public class bj_15988_123더하기3_Silver_2 {
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int TC = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            int[]arr = new int[TC];
            for(int t=0;t<TC;t++) arr[t] = Integer.parseInt(br.readLine());
            long[]dp = new long[1000001];
            dp[0] =0;dp[1] = 1;dp[2] = 2; dp[3] = 4;
            for(int i=4;i<1000001;i++){
                dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
            }
            for(int i=0;i<TC;i++) sb.append(dp[arr[i]]).append("\n");
            System.out.println(sb.toString());
        }
    }
