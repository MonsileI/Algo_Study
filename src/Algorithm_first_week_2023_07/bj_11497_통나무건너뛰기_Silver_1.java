package Algorithm_first_week_2023_07;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class bj_11497_통나무건너뛰기_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            int answer = 0;
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int[]tmp = new int[N];
            int L =0;
            int R = N-1;
            int idx = 0;
            for(int i=0;i<N;i++){
                if(i%2==0){
                    tmp[R--] = arr[i];
                }else{
                    tmp[L++] = arr[i];
                }
            }

            for(int i=1;i<N;i++) answer = Math.max(answer,Math.abs(tmp[i-1]-tmp[i]));
            answer = Math.max(answer,Math.abs(tmp[0]-tmp[N-1]));
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
