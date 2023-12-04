package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_19951_태상이의훈련소생활_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]cArr = new int[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            cArr[s] += p;
            cArr[e] += p *-1;

        }
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += cArr[i];
            arr[i] += sum;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }
}
