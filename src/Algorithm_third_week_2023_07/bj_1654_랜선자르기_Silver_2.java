package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1654_랜선자르기_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        long min = 0;
        long max = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }
        max++;
        long answer = 0;
        while(min<max){

            long sum = 0;
            long mid = (min+max) / 2;
            for(int i=0;i<N;i++) sum += arr[i]/mid;
            if(sum<K){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(min-1);

    }
}
