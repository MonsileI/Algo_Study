package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1758_알바생경호_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int idx = 1;
        long answer = 0;
        for(int i=N-1;-1<i;i--){
            int num = arr[i] -(idx-1);
            idx++;
            if(num<0)continue;
            answer += num;

        }
        System.out.println(answer);
    }
}
