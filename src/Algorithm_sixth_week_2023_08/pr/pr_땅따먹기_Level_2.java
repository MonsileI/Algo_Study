package Algorithm_sixth_week_2023_08.pr;

public class pr_땅따먹기_Level_2 {
    public static void main(String[] args) {
        int[][]land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int N = land.length;
        int[][]dp = new int[N+1][4];
        for(int i=0;i<4;i++) dp[0][i] = 0;

        for(int i=1;i<N+1;i++){
            dp[i][0] = Math.max(Math.max(dp[i-1][1],dp[i-1][2]),dp[i-1][3]) + land[i-1][0];
            dp[i][1] = Math.max(Math.max(dp[i-1][0],dp[i-1][2]),dp[i-1][3]) + land[i-1][1];
            dp[i][2] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][3]) + land[i-1][2];
            dp[i][3] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][2]) + land[i-1][3];
        }
        int answer = Math.max(Math.max(dp[N][0],dp[N][1]),Math.max(dp[N][2],dp[N][3]));
        System.out.println(answer);
    }
}
