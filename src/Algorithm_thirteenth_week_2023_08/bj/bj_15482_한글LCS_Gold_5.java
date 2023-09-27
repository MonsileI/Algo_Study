package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_15482_한글LCS_Gold_5 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int aLen = a.length();
        int bLen = b.length();
        int[][]lcs = new int[aLen+1][bLen+1];
        for(int i=1;i<aLen+1;i++){
            char fch = a.charAt(i-1);
            for(int j=1;j<bLen+1;j++){
                char sch = b.charAt(j-1);
                if(fch==sch)lcs[i][j] = lcs[i-1][j-1] +1;
                else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        System.out.println(lcs[aLen][bLen]);
    }
}
