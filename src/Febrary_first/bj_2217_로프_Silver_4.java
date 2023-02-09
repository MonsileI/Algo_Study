package Febrary_first;

import java.util.*;
import java.io.*;
public class bj_2217_로프_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int max = 0;
        int idx=1;
        for(int i=N-1;i>-1;i--){
            int num = arr[i];
            max = Math.max(num*idx,max);
            idx++;
        }
        System.out.println(max);

    }
}
