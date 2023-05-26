package May_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_20437_문자열게임2_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++){
            String str = br.readLine();
            int[]alpha = new int[26];
            int size = str.length();
            int K = Integer.parseInt(br.readLine());
            int min = 987654321; int max = 0;
            if(K==1) {sb.append("1 1").append("\n"); continue;}

            for(int i=0;i<size;i++) {
                char ch = str.charAt(i);
                alpha[ch - 97]++;
            }

            for(int i=0;i<=size-K;i++){

                char ch = str.charAt(i);
                if(K<=alpha[ch-97]){
                    int tmp = 1;
                    for(int j=i+1;j<size;j++){
                        char now = str.charAt(j);
                        if(ch==now){
                            tmp++;
                            if(tmp==K){
                                int len = (j - i)+1;
                                min = Math.min(min,len);
                                max = Math.max(max,len);
                                break;
                            }
                        }
                    }
                }
            }
            if(min==max) sb.append("-1").append("\n");
            else if(min==987654321 ||max==0)  sb.append("-1").append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
