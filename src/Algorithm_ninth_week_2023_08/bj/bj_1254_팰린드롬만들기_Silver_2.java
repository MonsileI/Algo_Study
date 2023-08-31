package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1254_팰린드롬만들기_Silver_2 {
    static int size;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        size = str.length();
        int answer = size;
        for(int i=0;i<size;i++){
            int start = i;
            if(check(start,str)) break;
            answer++;
        }
        System.out.println(answer);
    }
    static boolean check(int idx,String str){
        int L = idx; int R = size-1;
        while(L<=R){
            char f = str.charAt(L);
            char s = str.charAt(R);
            if(f!=s) return false;
            L++;
            R--;
        }
        return true;
    }
}
