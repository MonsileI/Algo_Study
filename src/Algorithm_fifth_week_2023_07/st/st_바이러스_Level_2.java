package Algorithm_fifth_week_2023_07.st;

import java.io.*;
import java.util.*;
public class st_바이러스_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long K = Integer.parseInt(input[0]);
        long P = Integer.parseInt(input[1]);
        long N = Integer.parseInt(input[2]);
        for(int i=0; i<N; i++) {
            K *= P;
            K %= 1000000007;
        }
        System.out.println(K);
    }
}
