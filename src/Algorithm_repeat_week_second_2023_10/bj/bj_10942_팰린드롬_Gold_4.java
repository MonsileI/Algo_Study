package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_10942_팰린드롬_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken())-1;
            int R = Integer.parseInt(st.nextToken())-1;
            boolean flag = true;
            while(L<=R){
                if(arr[L]!=arr[R]){
                    flag = false;
                    break;
                }
                L++; R--;
            }
            sb.append(flag ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }
}
