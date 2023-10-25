package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2872_우리집엔도서관이있어_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        int max = N-1;
        int max_idx = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]==N){
                max_idx = i;
            }
        }
        int len = 1;
        for(int i=max_idx;-1<i;i--){
            if(arr[i]==max){
                max--;
                len++;
            }
        }
        System.out.println(N-len);
    }
}
