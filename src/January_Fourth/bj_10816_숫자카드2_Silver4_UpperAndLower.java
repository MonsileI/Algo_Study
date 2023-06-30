package January_Fourth;

import java.io.*;
import java.util.*;

public class bj_10816_숫자카드2_Silver4_UpperAndLower {
    static int N,arr[];

    static int upperBound(int num){
        int l = 0;
        int r = N;
        while(l<r){
            int mid = (l+r)/2;
            if(num<arr[mid]) r = mid;
            else l = mid+1;
        }
        return l;
    }
    static int lowerBound(int num){
        int l = 0;
        int r = N;
        while(l<r){
            int mid = (l+r) /2;
            if(num<=arr[mid]) r = mid;
            else l = mid+1;
        }
        return l;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(num) - lowerBound(num)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
