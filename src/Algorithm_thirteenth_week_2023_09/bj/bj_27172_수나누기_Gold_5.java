package Algorithm_thirteenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_27172_수나누기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 1000001;
        int[]score = new int[size];
        boolean[]check = new boolean[size];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            check[arr[i]] = true;
            max = Math.max(max,arr[i]);
        }
        for(int i=0;i<N;i++){
            int num = arr[i];
            for(int j=num*2;j<=max;j+=num){
                if(check[j]){
                    score[j]--;
                    score[num]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) sb.append(score[arr[i]]+" ");
        System.out.println(sb.toString());
    }
}
