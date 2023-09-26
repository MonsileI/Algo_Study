package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_2343_기타레슨_Silver_1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int L =1; int R =0;
        int[]arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            R += arr[i];
            L = Math.max(L,arr[i]);
        }
        //upper bound
        while(L<R){
            int mid = (L+R)/2;
            if(check(arr,N,mid)>M) L = mid+1;
            else R = mid;
        }
        System.out.println(L);

    }
    static int check(int[]arr,int N,int mid){

        int cnt = 0;
        int now = 0;
        for(int i=0;i<N;i++){
            if(mid<now+arr[i]){
                cnt++;
                now = 0;
            }
             now += arr[i];

        }
        if(now!=0) cnt++;
        return cnt;
    }
}
