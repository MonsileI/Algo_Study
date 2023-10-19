package Algorithm_repeat_week_second_2023_10.bj.binarySerch;

import java.util.*;
import java.io.*;
public class bj_2512_예산_Silver_2 {
    static int N,M,arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int L = 0; int R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R,arr[i]);
        }
        R++;
        M = Integer.parseInt(br.readLine());
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)<=M) L = mid+1;
            else R = mid;
        }
        System.out.println(L-1);
    }
    static int check(int mid){
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(arr[i]>mid) cnt +=mid;
            else cnt += arr[i];
        }

        return cnt;

    }

}
