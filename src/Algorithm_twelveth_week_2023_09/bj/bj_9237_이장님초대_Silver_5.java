package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_9237_이장님초대_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        Arrays.sort(arr);
        int idx = 1;
        for(int i=N-1;-1<i;i--){
            answer = Math.max(answer,arr[i]+idx);
            idx++;
        }
        System.out.println(answer+1);
    }
}
