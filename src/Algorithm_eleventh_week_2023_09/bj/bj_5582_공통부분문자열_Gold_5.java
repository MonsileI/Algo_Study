package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_5582_공통부분문자열_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();
        int fSize = f.length();
        int sSize = s.length();
        int[][] lcs = new int[fSize+1][sSize+1];
        int answer = 0;
        for(int i=1;i<fSize+1;i++){
            char fch = f.charAt(i-1);
            for(int j=1;j<sSize+1;j++){
                char sCh = s.charAt(j-1);
                if(fch==sCh){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                    answer = Math.max(answer,lcs[i][j]);
                }
            }

        }
        System.out.println(answer);
    }
}
