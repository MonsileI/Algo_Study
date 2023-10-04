package Algorithm_foureenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_28357_사탕나눠주기_Silver_2 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[]arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);
        long L = 0;
        long R = arr[N-1]+1;
        while(L<R){
            long mid = (L+R)/2;
            long sum = 0;
            for(int i=0;i<N;i++) if(mid<arr[i]) sum += (arr[i]-mid);
            if(sum<=M){
                R = mid;
            }else{
                L = mid+1;
            }
        }
        System.out.println(L);
    }
}
