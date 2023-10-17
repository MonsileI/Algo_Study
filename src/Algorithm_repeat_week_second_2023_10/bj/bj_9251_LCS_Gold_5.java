package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_9251_LCS_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();
        int fSize = f.length();
        int sSize = s.length();
        int[][]dp = new int[fSize+1][sSize+1];
        for(int i=1;i<fSize+1;i++){
            char fCh = f.charAt(i-1);
            for(int j=1;j<sSize+1;j++){
                char sCh= s.charAt(j-1);
                if(fCh==sCh) dp[i][j]= dp[i-1][j-1]+1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[fSize][sSize]);
    }
}
