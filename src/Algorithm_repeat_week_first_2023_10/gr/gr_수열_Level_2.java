package Algorithm_repeat_week_first_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_수열_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]p = new int[N+1];
        if(N==1) System.out.println(0);
        else if(N==2) System.out.println(1);
        else{
            p[1] = 0;
            p[2] = 1;
            for(int i=3;i<N+1;i++) p[i] = (p[i-1]+p[i-2])%1000000007;
            System.out.println(p[N]);
        }
    }
}
