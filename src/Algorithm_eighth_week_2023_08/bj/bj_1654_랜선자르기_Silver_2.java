package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1654_랜선자르기_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int K= Integer.parseInt(st.nextToken());
        int N= Integer.parseInt(st.nextToken());
        int[]arr = new int[K];
        int L = 0;
        int R  = 0;
        for(int i=0;i<K;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R,arr[i]);
        }
        while(L<R){
            int mid = (L+R)/2;
            int sum  =0;
            for(int i=0;i<K;i++){
                sum += arr[i]/mid;
            }
            if(N<=sum){
                L = mid+1;
            }else{
                R = mid-1;
            }

        }
        System.out.println(L);

    }
}
