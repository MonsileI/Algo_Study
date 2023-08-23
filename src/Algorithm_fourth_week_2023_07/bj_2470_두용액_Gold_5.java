package Algorithm_fourth_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_2470_두용액_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int[]answer = new int[2];
        int min = Integer.MAX_VALUE;
        int L =0; int R=N-1;
        while(L<R){
            int sum = Math.abs(arr[L]+arr[R]);
            if(sum<min){
                answer[0] = arr[L];
                answer[1] = arr[R];
                min = sum;
            }
            if(arr[L]+arr[R]>0){
                R--;
            }else{
                L++;
            }

        }
        System.out.println(answer[0]+" "+answer[1]);

    }
}
