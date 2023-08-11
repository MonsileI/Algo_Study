package Algorithm_sixth_week_2023_08.dp;

import java.util.*;
public class pr_거스름돈_Level_2 {
    public static void main(String[] args) {
        int n = 5;
        int[]money = {1,2,5};
        int answer = 0;
        int size = money.length;
        int[][]dp = new int[size+1][n+1];
        for(int i=0;i<size+1;i++) dp[i][0] = 1;
        for(int i=1;i<size+1;i++){
            int m = money[i-1];
            for(int j=1;j<n+1;j++){
                dp[i][j] = dp[i-1][j]%(1000000007);
                if(m<=j) dp[i][j] += dp[i][j-m];
            }
        }

        System.out.println(dp[size][n]);
    }
}
