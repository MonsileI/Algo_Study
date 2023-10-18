package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_17951_흩날리는시험지속에내평점이느껴진거야_Gold_4 {
    static int N,M,arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = 0; int R = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            R += num;
        }
        while(L<=R){
            int mid = (L+R)/2;
            if(check(mid)>M) L = mid+1;
            else R = mid-1;
        }
        System.out.println(L-1);
    }
    static int check(int mid){
        int cnt = 1;
        int sum = arr[0];
        for(int i=1;i<N;i++){
            sum += arr[i];
            if(sum>=mid){
                sum = 0;
                cnt++;
            }
        }
        return cnt;
    }
}
