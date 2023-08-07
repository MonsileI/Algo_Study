package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_24390_또전자레인지야_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []time = br.readLine().split(":");
        int m = Integer.parseInt(time[0]);
        int s = Integer.parseInt(time[1]);
        int answer =0;
        boolean check = false;
        if(s!=0){
            while(s!=0){
                if(30<=s) {
                    s -=30;
                    answer++;
                    check = true;
                }else{
                    s -= 10;
                    answer++;
                }
            }
        }

        while(m!=0){
            if(10<=m) {
                m-=10;
                answer++;
            }else if(1<=m){
                m--;
                answer++;
            }
        }
        if(!check) answer++;
        System.out.println(answer);
    }
}
