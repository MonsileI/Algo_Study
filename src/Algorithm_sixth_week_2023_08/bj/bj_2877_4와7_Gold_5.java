package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2877_4와7_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())+1;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(N!=0){
            num = N%2;
            sb.append(num);
            N /= 2;
        }
        StringBuilder result = new StringBuilder();
        for(int i=sb.toString().length()-2;-1<i;i--){
            if(sb.charAt(i)=='0') result.append(4);
            else result.append(7);
        }
        System.out.println(result.toString());
    }
}
