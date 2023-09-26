package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_13398_연속합2_Gold_5 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]dpL = new int[N];
        dpL[0] = arr[0];
        int max = dpL[0];
        for(int i=1;i<N;i++){
           dpL[i] = Math.max(dpL[i-1]+arr[i],arr[i]);
           max = Math.max(max,dpL[i]);
        }
        int[]dpR = new int[N];
        dpR[N-1] = arr[N-1];
        for(int i=N-2;-1<i;i--) dpR[i] = Math.max(dpR[i+1] + arr[i], arr[i]);
        for(int i=1;i<N-1;i++){
            int tmp = dpL[i-1] + dpR[i+1];
            max = Math.max(max,tmp);
        }
        System.out.println(max);

    }
}