package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;

public class bj_7795_먹을것인가먹힐것인가_Silver_3 {
    static int N,arr[];
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) binarySearch(Integer.parseInt(st.nextToken()));
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void binarySearch(int num){
        int L = 0; int R = N-1;
        int mid = 0;
        while(L<=R){
             mid = (L+R)/2;
            if(arr[mid]>num){
                R = mid-1;
            }else{
                L = mid+1;
            }
        }

        answer += (N - L);
    }
}
