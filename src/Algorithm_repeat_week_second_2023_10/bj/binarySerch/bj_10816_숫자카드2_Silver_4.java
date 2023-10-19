package Algorithm_repeat_week_second_2023_10.bj.binarySerch;

import java.util.*;
import java.io.*;
public class bj_10816_숫자카드2_Silver_4 {
    static int N;
    static int [] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(up(num)-down(num)+" ");
        }
        System.out.println(sb.toString());
    }
    static int up(int num){

        int L = 0 ; int R = N;
        while(L<R){
            int mid = (L+R)/2;
            if(num<arr[mid]) R = mid;
            else L = mid+1;
        }
        return L;
    }
    static int down(int num){

        int L = 0 ; int R = N;
        while(L<R){
            int mid = (L+R)/2;
            if(num<=arr[mid]) R = mid;
            else L = mid+1;
        }
        return L;
    }
}
