package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_10815_숫자카드_Silver_5 {
    static int[]arr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(search(num)).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int search(int num){
        int L = 0; int R = N-1;

        while(L<=R){

            int mid = (L+R)/2;

            if(arr[mid]>=num){
                if(arr[mid]==num)return 1;
                R = mid-1;
            }else{
                L = mid+1;
            }
        }

        return 0;
    }
}
