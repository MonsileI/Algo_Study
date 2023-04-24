package April_Fourth;

import java.util.*;
import java.io.*;
public class bj_12904_A와B_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        int sSize = S.length()-1;
        int tSize = T.length()-1;

        while(sSize<tSize){

            char ch = T.charAt(tSize);
            //A면 제거
            if(ch=='A') T = T.substring(0,tSize);
                //B면 제거 뒤집기
            else{
                T = T.substring(0,tSize);
                String a = "";
                for(int i=tSize-1;-1<i;i--) a += T.charAt(i);
                T = a;
            }

            tSize--;
            System.out.println(T);
        }
        int answer = 1;

        for(int i=0;i<sSize+1;i++){
            char s = S.charAt(sSize);
            char t = T.charAt(tSize);
            if(s!=t){answer =0 ; break;};
        }
        System.out.println(answer);
    }
}
