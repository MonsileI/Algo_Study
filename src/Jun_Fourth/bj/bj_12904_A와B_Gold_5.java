package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_12904_A와B_Gold_5 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        int fSize = fir.length()-1;
        int size = sec.length();
        int answer = 0;
        int idx = size-1;
        String tmp = "";

        while(true){
            char ch = sec.charAt(idx);
            if(ch=='A') sec = sec.substring(0,idx--);
            else{
                sec = sec.substring(0,idx--);
                tmp = "";
                for(int i=idx;-1<i;i--){
                    tmp += sec.charAt(i);
                }
                sec = tmp;
            }
            if(fSize==idx){
                if(fir.equals(sec)) answer = 1;
                break;
            }
        }

        System.out.println(answer);
    }
}
