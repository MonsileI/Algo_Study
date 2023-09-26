package Algorithm_tenth_week_2023_09.복습;

import java.util.*;
import java.io.*;
public class bj_2343_기타레슨_Silver_1 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int L=0; int R=0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R += arr[i];
            L = Math.max(L,arr[i]);
        }
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)>M) L = mid+1;
            else R = mid;
        }
        System.out.println(L);

    }
    static int check(int mid){
        int cnt = 0;
        int now = 0;
        for(int i=0;i<N;i++){
            if(mid<now+arr[i]) {
                cnt++;
                now = 0;
            }
            now += arr[i];
        }
        if(now!=0) cnt++;
        return cnt;
    }
}
