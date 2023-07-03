package January_Fourth;

import java.util.*;
import java.io.*;

public class test {
    static int N,arr[];

    static int lower(int num){
        int l = 0; int r = N;
        while(l<r){
            int mid = (l+r)/2;
            if(num<=arr[mid]) r = mid;
            else l = mid+1;
        }
        return l;
    }
    static int upper(int num){
        int l = 0; int r = N;
        while(l<r){
            int mid = (l+r)/2;
            if(num<arr[mid]) r = mid;
            else l = mid+1;
        }
        return l;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(upper(num) - lower(num)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
