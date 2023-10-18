package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_13397_구간나누기2_Gold_4 {
    static int N;
    static int M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int L = 0 ; int R = 10000;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R,arr[i]);
        }
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)>M) L = mid+1;
            else R = mid;
        }
        System.out.println(L);
    }
    static int check(int mid){

        int cnt = 1;
        int min = 987654321;
        int max = -987654321;
        for(int i=0;i<N;i++){
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
            if(max-min>mid){
                cnt++;
                max = -987654321;
                min = 987654321;
                i--;
            }
        }
        return cnt;
    }
}
