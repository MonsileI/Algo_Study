package Algorithm_sixth_week_2023_08.pr;

public class pr_멀리뛰기_Level_2 {
    public static void main(String[] args) {
        int n = 4;
        int[]dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        System.out.println(dp[n]);
    }
}
