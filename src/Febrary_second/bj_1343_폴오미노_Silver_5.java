package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_1343_폴오미노_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "";

        int num=0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch!='.'){
                num++;
            }else{
                if(num%2!=0) {
                    ans = "-1";
                    break;
                }else{

                    innerWhile:
                    while(-1<num){
                        if(4<=num){
                        num -= 4;
                        ans += "AAAA";
                        }else if(num==2){
                         ans += "BB";
                         break innerWhile;
                        }else break innerWhile;
                    }
                }
                ans += ".";
                num = 0;

            }
        }

        if(num%2!=0) ans = "-1";
        else{
            while(-1<num){
                if(4<=num){
                    num -= 4;
                    ans += "AAAA";
                }else if(num==2){
                    ans += "BB";
                    break;
                }else break;
            }
        }
        System.out.println(ans);


    }
}
