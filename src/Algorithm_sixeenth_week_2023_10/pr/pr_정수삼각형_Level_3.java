package Algorithm_sixeenth_week_2023_10.pr;

public class pr_정수삼각형_Level_3 {
    public static void main(String[] args) {
        int[][] triangle = {{7},{3, 8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}};
        int[][]dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            for(int j=1;j<i;j++) dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j],dp[i-1][j-1]);
        }
        int ans = 0;
        for(int j=0;j<triangle.length;j++) ans = Math.max(ans,dp[triangle.length-1][j]);
        System.out.println(ans);
    }
}
