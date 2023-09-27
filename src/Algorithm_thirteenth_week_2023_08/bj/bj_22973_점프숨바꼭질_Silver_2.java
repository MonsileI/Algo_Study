package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_22973_점프숨바꼭질_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if(N<0) N *= -1;
        long jump = 1;
        long answer = 0;
        while(0<N){
            N -= jump;
            jump *= 2;
            answer++;
        }
        if(N!=0) System.out.println(-1);
        else System.out.println(answer);

    }
}
