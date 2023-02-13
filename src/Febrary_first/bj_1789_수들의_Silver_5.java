package Febrary_first;

import java.util.*;
import java.io.*;
public class bj_1789_수들의_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long tmp = 1;
        long ans = 0;
        while(0<n){
            if(n-tmp <= tmp){
                ans++;
                break;
            }else{
                n -= tmp;
                ans++;
                tmp++;
            }

        }
        System.out.println(ans);
    }
}
