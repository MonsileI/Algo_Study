package Algorithm_second_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_10816_숫자카드2_Silver_4 {
    static int []arr;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(upper(num)-lower(num)).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int upper(int num){
        int L = 0; int R = N-1;
        int mid = 0;
        while(L<R){
            mid = (L+R)/2;
            if(arr[mid]>num){
                R = mid-1;
            }else{
                L = mid+1;
            }
        }
        return L;
    }

    static int lower(int num){
        int L = 0; int R = N-1;
        int mid = 0;
        while(L<R){
            mid = (L+R)/2;
            if(arr[mid]>=num){
                R = mid-1;
            }else{
                L = mid+1;
            }
        }
        return L;
    }
}
