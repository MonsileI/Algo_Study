package Febrary_first;

import java.util.*;
import java.io.*;

public class bj_1920_수찾기_Silver_4 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            boolean flag = false;
            while(start<=end){
                int mid = (start+end)/2;

                if(num<=arr[mid]) end = mid-1;
                else start = mid+1;

                if(arr[mid]==num) {
                    flag=true;
                    break;
                }
            }
            if(flag) sb.append(1).append("\n");
            else sb.append(0).append("\n");

        }

        System.out.println(sb.toString());

    }
}
