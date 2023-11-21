package Algorithmeighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_2343_기타레슨_Silver_1 {
    static int N,M,arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        int L = 0; int R =0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R += arr[i];
            L = Math.max(L,arr[i]);
        }
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)<=M) R = mid;
            else L = mid+1;
        }
        System.out.println(L);

    }
    static int check(int mid){
        int tmp = 1;
        int sum = 0;
        for(int i=0;i<N;i++){
            if(sum+arr[i]>mid){
                sum = arr[i];
                tmp++;
            }else{
                sum += arr[i];
            }
        }
        return tmp;
    }
}
