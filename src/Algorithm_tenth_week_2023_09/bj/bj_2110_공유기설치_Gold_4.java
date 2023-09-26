package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_2110_공유기설치_Gold_4 {
    static int N,C;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        //띄워져있는 거리를 계산
        int L =1; int R = arr[N-1] - arr[0] + 1;
        while(L<R){
            int mid = (L+R)/2;
            if(calc(mid)<C) R = mid;
            else L = mid+1;
        }
        System.out.println(L-1);
    }
    static int calc(int range){
        int cnt = 1;
        int before = arr[0];
        for(int i=1;i<N;i++){
            int now = arr[i];

            if(range<=(now-before)){
                cnt++;
                before = now;
            }
        }
        return cnt;
    }
}
