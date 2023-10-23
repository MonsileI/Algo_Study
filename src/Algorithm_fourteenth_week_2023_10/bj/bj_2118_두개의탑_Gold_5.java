package Algorithm_fourteenth_week_2023_10.bj;

import java.io.*;
public class bj_2118_두개의탑_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        int total = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        //토탈 - 구간값 vs 구간값

        int answer = 0;
        int L = 0;
        int R = 0;
        int now = arr[0];
        while(L<=R && R<N){
             int minNow = Math.min(now,total-now);
             answer = Math.max(answer,minNow);
             if(now==minNow){
                R++;
                now += arr[R];
            }else{
                now -= arr[L];
                L++;
            }
        }
        System.out.println(answer);
    }
}
