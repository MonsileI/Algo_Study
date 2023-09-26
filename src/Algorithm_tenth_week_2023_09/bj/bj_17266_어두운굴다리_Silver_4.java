package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_17266_어두운굴다리_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int L = 1; int R = N;
        int[]arr= new int[M];
        for(int i=0;i<M;i++)arr[i] = Integer.parseInt(st.nextToken());
        while(L<R){

            int mid = (L+R)/2;

            if(check(arr,mid,N,M)){
                R = mid;
            }else{
                L = mid+1;
            }

        }
        System.out.println(L);
    }
    static boolean check(int[]arr,int mid,int N,int M){

        if(0<arr[0]-mid) return false;

        int right = arr[0]+mid;

        for(int i=1;i<M;i++){
            if(right<arr[i]-mid) return false;
            right = arr[i]+mid;
        }
        if(right<N) return false;
        return true;
    }
}
