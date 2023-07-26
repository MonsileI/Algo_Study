package Algorithm_fourth_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_17609_회문_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            String str = br.readLine();
            int L = 0; int R = str.length()-1;
            if(check(str,L,R))sb.append(0).append("\n");
            else{
                if(checkS(str)) sb.append(1).append("\n");
                else sb.append(2).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean checkS(String str){
        int L =0; int R = str.length()-1;
        while(L<=R){
            char f = str.charAt(L); char s = str.charAt(R);
            if(f!=s) {
                boolean changeL = check(str,L+1,R);
                boolean changeR = check(str,L,R-1);
                if(!changeL && !changeR) return false;
                else return true;
            }
            L++;R--;
        }
        return true;
    }
    static boolean check(String str,int L,int R){

        while(L<=R){
            char f = str.charAt(L); char s = str.charAt(R);
            if(f!=s) return false;
            L++;R--;
        }
        return true;
    }
}
