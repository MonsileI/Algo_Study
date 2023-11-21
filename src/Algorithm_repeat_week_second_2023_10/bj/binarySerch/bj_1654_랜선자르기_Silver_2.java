package Algorithm_repeat_week_second_2023_10.bj.binarySerch;

import java.util.*;
import java.io.*;
public class bj_1654_랜선자르기_Silver_2 {
    static int N,M,arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        long L = 0; long R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R,arr[i]);
        }
        R++;
        while(L<R){
            long mid = (L+R)/2;
            if(check(mid)>=M) L = mid+1;
            else R = mid;
        }
        System.out.println(L-1);

    }
    static long check(long mid){
        int cnt = 0;
        for(int i=0;i<N;i++){
            cnt += arr[i]/mid;
        }
        return cnt;
    }
}
