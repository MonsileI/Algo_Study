package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2776_암기왕_Silver_4 {
    static int N,arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++) sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int binarySearch(int num){
        int L = 0 ; int R = N-1;
        while(L<=R){
            int mid = (L+R)/2;
            if(arr[mid]<num){
                L = mid+1;
            }else{
                if(arr[mid]==num) return 1;
                R = mid-1;
            }
        }
        return 0;
    }
}
