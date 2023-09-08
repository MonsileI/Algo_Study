package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_1259_팰린드롬수_Bronze_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;
            if(check(str)) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb.toString());
    }
    static boolean check(String str){
        int L = 0; int R = str.length()-1;
        while(L<=R){
            if(str.charAt(L)!=str.charAt(R)) return false;
            L++; R--;
        }
        return true;
    }
}
