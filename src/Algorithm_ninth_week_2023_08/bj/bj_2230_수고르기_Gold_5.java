package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2230_수고르기_Gold_5 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        int L=0; int R=0;
        int answer = Integer.MAX_VALUE;
        Arrays.sort(arr);
        while(R<N){
            if(arr[R]-arr[L]<M) {
                R++; continue;
            }
            if(arr[R]-arr[L]==M){
                answer = M;
                break;
            }
            answer = Math.min(answer,arr[R]-arr[L]);
            L++;
        }
        System.out.println(answer);
    }
}
