package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_2012_등수매기기_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine())-1;
        Arrays.sort(arr);
        long answer = 0;
        for(int i=0;i<N;i++) answer += Math.abs(arr[i]-i);
        System.out.println(answer);

    }
}
