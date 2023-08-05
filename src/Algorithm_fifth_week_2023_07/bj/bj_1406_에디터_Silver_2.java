package Algorithm_fifth_week_2023_07.bj;

import java.io.*;
import java.util.*;

public class bj_1406_에디터_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int TC = Integer.parseInt(br.readLine());
        int idx = str.length();
        for(int t=0;t<TC;t++){
            String order = br.readLine();
            if(order.charAt(0)=='P'){
                char ch = order.charAt(2);
                String tmp = str.substring(0,idx);
                tmp += ch;
                tmp += str.substring(idx,str.length());
                str = tmp;
                idx++;
            }else{
                switch (order.charAt(0)){
                    case 'L': if(idx!=0) idx--;
                    break;
                    case 'D':if(idx < str.length())idx++;
                    break;
                    case 'B':{
                        if(idx!=0&&str.length()!=0){
                            String tmp = str.substring(0,idx-1);
                            tmp += str.substring(idx,str.length());
                            str = tmp;
                            idx--;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(str);
    }
}
