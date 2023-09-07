package Algorithm_tenth_week_2023_09.복습;

import java.util.*;
import java.io.*;
public class bj_9251_LCS_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        int fSize = fir.length(); int sSize = sec.length();
        int[][]map = new int[fSize+1][sSize+1];
        for(int i=1;i<fSize+1;i++){
            char fch = fir.charAt(i-1);
            for(int j=1;j<sSize+1;j++){
                char sch = sec.charAt(j-1);
                if(fch==sch) map[i][j] = map[i-1][j-1] +1;
                else{
                    map[i][j] = Math.max(map[i-1][j],map[i][j-1]);
                }
            }
        }
        System.out.println(map[fSize][sSize]);
    }
}
