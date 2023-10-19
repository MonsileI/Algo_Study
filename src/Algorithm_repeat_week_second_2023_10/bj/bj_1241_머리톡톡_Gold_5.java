package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1241_머리톡톡_Gold_5 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        int[]dist = new int[1000001];
        int[]answer = new int[N];
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            dist[num]++;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            int tmp = arr[i];

            for(int j=1;j<=Math.sqrt(tmp);j++){
                if(tmp%j==0){
                    answer[i] += dist[j];
                    if(j*j<tmp){
                        answer[i] += dist[tmp/j];
                    }
                }
            }
            sb.append(answer[i]-1+"\n");
        }
        System.out.println(sb.toString());
    }
}
