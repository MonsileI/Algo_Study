package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_1477_휴게소세우기_Gold_4 {
    static int N,M,Range;

    static int[]arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Range = Integer.parseInt(st.nextToken());
        arr = new int[N+2];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
        arr[N+1] = Range;
        Arrays.sort(arr);
        int L = 1; int R = Range-1;
        while(L<=R){
            int mid = (L+R)/2;
            if(check(mid)<=M) R = mid-1;
            else L = mid+1;
        }
        System.out.println(L);
    }
    static int check(int num){
        int cnt = 0;
        for(int i=1;i<N+2;i++){
            cnt += (arr[i]-arr[i-1]-1)/num;
        }

        return cnt;
    }
}
