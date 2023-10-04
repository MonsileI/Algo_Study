package Algorithm_thirteenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_19951_태상이의훈련소생활_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]tmp = new int[N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(e==N){
                tmp[s-1] += w;
            }else{
                tmp[s-1] += w;
                tmp[e] += w * -1;
            }
        }
        int[]sumArr = new int[N];
        int sum = 0;
        for(int i=0;i<N;i++) {
            sum += tmp[i];
            sumArr[i] = sum;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)  sb.append(arr[i]+sumArr[i]+" ");
        System.out.println(sb.toString());
    }
}
