package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_14916_거스름돈_Silver_5 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //2원이랑 5원만
        int ans = 0;
        while(n!=0){

            if(n%5==0){
                ans += n/5;
                break;
            }else{
                n -= 2;
                ans++;
            }

        }

        if(n<0) ans = -1;
        System.out.println(ans);

    }
}
