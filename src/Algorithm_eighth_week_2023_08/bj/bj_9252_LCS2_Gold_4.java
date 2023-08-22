package Algorithm_eighth_week_2023_08.bj;

import java.io.*;
import java.util.*;
public class bj_9252_LCS2_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        StringBuilder sb = new StringBuilder();
        int fSize= fir.length(); int sSize = sec.length();
        int[][]lcs = new int[fSize+1][sSize+1];
        for(int i=1;i<fSize+1;i++){
            for(int j=1;j<sSize+1;j++){
                if(fir.charAt(i-1)==sec.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] +1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        sb.append(lcs[fSize][sSize]+"\n");
        Stack<Character> st = new Stack<>();
        while(0<fSize && 0<sSize){

            if(fSize<0||sSize<0) break;
            if(lcs[fSize][sSize]==lcs[fSize-1][sSize]) fSize--;
            else if(lcs[fSize][sSize]==lcs[fSize][sSize-1]) sSize--;
            else{
                st.push(fir.charAt(fSize-1));
                fSize--; sSize--;
            }
        }
        while(!st.isEmpty()) sb.append(st.pop());
        System.out.println(sb.toString());
    }
}
