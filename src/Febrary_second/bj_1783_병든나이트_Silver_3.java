package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_1783_병든나이트_Silver_3 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ans = 0;
        if(N==1) ans = 1;
        else if(N==2) ans = Math.min(4,(M+1)/2);
        else{
            if(M>=7) ans = M-2;
            else ans = Math.min(4,M);
        }
        System.out.println(ans);
    }
}
