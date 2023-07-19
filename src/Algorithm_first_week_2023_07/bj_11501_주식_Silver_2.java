package Algorithm_first_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_11501_주식_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            long answer = 0;
            int N = Integer.parseInt(br.readLine());
            long[]arr = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            long max = arr[N-1];

            for(int i=N-2;-1<i;i--){
                if(arr[i]<max){
                    answer += max;
                    answer -= arr[i];
                }else max = arr[i];

            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
