package Algorithm_seventh_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_A4용지를만들자_level_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long answer = 0;
        if(N>19&&M>19){
            if(39<N||39<M){
                long max = Math.max(N,M);
                long min = Math.min(N,M);
                answer = (min/40) * (max/20);
                answer = Math.max(answer,((min/20)*(max/40)));
            }
        }
        System.out.println(answer);
    }
}
