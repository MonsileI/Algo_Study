package Algorithm_seventh_week_2023_08.gr;

import java.io.*;
import java.util.*;

public class gr_거울단어_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //b d
        //p q
        //s z

        //i l m n o u v w x

        String check = "acefghjkrty";
        String OneCheck = "ilmnouvwx";

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            boolean flag = true;
            String str = br.readLine();
            if(str.length()==1) {
                if(OneCheck.indexOf(str.charAt(0))==-1){
                    sb.append("Normal\n");
                    continue;
                }else{
                    sb.append("Mirror\n");
                    continue;
                }
            }
            int L = 0; int R = str.length()-1;
            while(L<=R){
                char f = str.charAt(L);
                char s = str.charAt(R);
                if(f==s){
                    if(check.indexOf(f)==-1){
                        L++;
                        R--;
                    }else{
                        flag= false;
                        break;
                    }
                }else{
                    if(check.indexOf(f)!=-1||check.indexOf(s)!=-1){
                        flag = false;
                        break;
                    }
                    else if((f=='b'&&s=='d')||(f=='d'&&s=='b')){
                        L++;
                        R--;
                    }else if((f=='p'&&s=='q') || (f=='q'&&s=='p')){
                        L++;
                        R--;
                    }else if((f=='s'&&s=='z')||(f=='z'&&s=='s')){
                        L++;
                        R--;
                    }else{
                        flag= false;
                        break;
                    }
                }
            }
            sb.append(flag ? "Mirror\n" : "Normal\n");
        }
        System.out.println(sb.toString());
    }
}
