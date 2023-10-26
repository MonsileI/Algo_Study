package Algorithm_fifteenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_1334_다음팰린드롬수_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        //홀수일때 짝수일 때 구분해주자
        StringBuilder sb=  new StringBuilder();
        if(str.length()%2==1){
            int i =0;
            int j =str.length()/2-1;
            for(i=0;i<str.length()/2;i++) sb.append(str.charAt(i));
            sb.append(Integer.parseInt(str.charAt(i)+"")+1);
            for(i=(str.length()/2)+1;i<str.length();i++) sb.append(str.charAt(j--));
        }else{
            int i =0;
            int j =str.length()/2-1;
            for(i=0;i<str.length()/2;i++) sb.append(str.charAt(i));
            sb.append(Integer.parseInt(str.charAt(i)+"")+1);
            sb.append(Integer.parseInt(str.charAt(i+1)+"")+1);
            for(i=str.length()/2;i<str.length();i++) sb.append(str.charAt(j--));


        }
        System.out.println(sb.toString());
    }
}
