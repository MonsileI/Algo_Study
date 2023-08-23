package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1958_LCS3_Gold_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        String thi = br.readLine();
        int fSize= fir.length(); int sSize = sec.length(); int tSize = thi.length();
        int[][][]lcs = new int[fSize+1][sSize+1][tSize+1];

        for(int i=1;i<fSize+1;i++){
            for(int j=1;j<sSize+1;j++){
                for(int k=1;k<tSize+1;k++){
                    if(fir.charAt(i-1)==sec.charAt(j-1)&& sec.charAt(j-1)==thi.charAt(k-1)){
                        lcs[i][j][k] = lcs[i-1][j-1][k-1] +1;
                    }else{
                        lcs[i][j][k] = Math.max(Math.max(lcs[i-1][j][k],lcs[i][j-1][k]),lcs[i][j][k-1]);
                    }
                }
            }
        }
        System.out.println(lcs[fSize][sSize][tSize]);

    }
}
