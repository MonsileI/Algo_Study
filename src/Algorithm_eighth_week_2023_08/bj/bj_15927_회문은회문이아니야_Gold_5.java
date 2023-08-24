package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_15927_회문은회문이아니야_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = -1;
        int size=  str.length();
        boolean flag = false;
        for(int i=0;i<size/2;i++){
            if(str.charAt(i)!=str.charAt(size-i-1)){
                answer = str.length();
                flag = false;
                break;
            }else if(str.charAt(i)!=str.charAt(i+1)){
                flag= true;
            }

        }
        if(flag) answer = str.length()-1;

        System.out.println(answer);
    }
}
