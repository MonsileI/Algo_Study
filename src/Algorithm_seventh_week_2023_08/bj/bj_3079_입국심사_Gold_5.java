package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_3079_입국심사_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        long[]arr=  new long[N];
        long max = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }

        long L = 0;  long R = max * M;
        long result = R;

        while(L<=R){

            long mid = (L+R)/2;
            long sum = 0;

            for(long idx : arr){
                sum += (mid/idx);
                if(sum>=M) break;
            }
            if(sum>=M){
                R = mid-1;
                result = Math.min(result,mid);
            }else{
                L = mid+1;
            }
        }
        System.out.println(result);
    }
}
