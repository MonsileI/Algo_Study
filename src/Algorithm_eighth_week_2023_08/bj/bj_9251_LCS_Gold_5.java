package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_9251_LCS_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        int fSize = fir.length(); int sSize= sec.length();
        int[][]lcs = new int[fSize+1][sSize+1];
        for(int i=1;i<fSize+1;i++){
            for(int j=1;j<sSize+1;j++){
                if(fir.charAt(i-1)==sec.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }

            }
        }
        System.out.println(lcs[fSize][sSize]);
    }
}
