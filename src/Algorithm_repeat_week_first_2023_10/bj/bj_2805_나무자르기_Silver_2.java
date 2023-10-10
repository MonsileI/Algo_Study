package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2805_나무자르기_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr=  new int[N];
        st = new StringTokenizer(br.readLine()," ");
        long L = 0; long R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R,arr[i]);
        }

        while(L<R){
            long mid = (L+R)/2;
            long sum = 0;
            for(int i=0;i<N;i++){
                if(0<arr[i]-mid) sum += arr[i]-mid;
            }
            if(sum<M) R = mid;
            else L = mid+1;
        }
        System.out.println(L-1);
    }
}
