package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1789_수들의합_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        int answer = 0;
        int idx = 1;
        while(true){
            num -= idx;
            if(num<0) break;
            idx++;
            answer++;
        }
        System.out.println(answer);
    }
}
