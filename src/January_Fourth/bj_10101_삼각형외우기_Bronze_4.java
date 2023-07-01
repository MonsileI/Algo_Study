package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_10101_삼각형외우기_Bronze_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fir = Integer.parseInt(br.readLine());
        int sec = Integer.parseInt(br.readLine());
        int thi = Integer.parseInt(br.readLine());
        System.out.println(cal(fir,sec,thi));
    }
    static String cal(int f,int s,int t){
        int sum = f+s+t;
        if(f==60 && s==60 && t==60) return "Equilateral";
        else if(sum==180){
            if(f!=s && s!=t && f!=t) return "Scalene";
            else return "Isosceles";
        }
        return "Error";
    }
}
