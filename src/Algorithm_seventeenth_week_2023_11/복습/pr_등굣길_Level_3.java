package Algorithm_seventeenth_week_2023_11.복습;

import java.lang.reflect.Array;
import java.util.Arrays;

public class pr_등굣길_Level_3 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][]puddles = {{2,2}};
        int[][]map = new int[n+1][m+1];
        for(int i=0;i<puddles.length;i++) map[puddles[i][0]][puddles[i][1]] = 1;
       
        int mod =  1000000007;
        map[1][1] = 1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(map[i][j]==-1) continue;
                if(map[i-1][j]>0) map[i][j] += map[i-1][j] % mod;
                if(map[i][j-1]>0) map[i][j] += map[i][j-1] % mod;
            }
        }

        System.out.println(map[n][m]);

    }
}
