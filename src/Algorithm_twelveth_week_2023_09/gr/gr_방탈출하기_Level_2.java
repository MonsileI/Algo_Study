package Algorithm_twelveth_week_2023_09.gr;

import java.util.*;
import java.io.*;

public class gr_방탈출하기_Level_2 {
    static int N,arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(i==M-1){
                if(check(num)) sb.append(1);
                else sb.append(0);
            }else{
                if(check(num)) sb.append(1+"\n");
                else sb.append(0+"\n");
            }

        }
        System.out.println(sb.toString());
    }
    static boolean check(int num){

        int L = 0; int R = N;
        while(L<R){
            int mid = (L+R)/2;
            if(num<arr[mid]){
                R = mid;
            }else {
                if(arr[mid]==num) return true;
                L = mid+1;
            }
        }
        return false;
    }
}
