package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_11054_가장바이토부분수열_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]LISL = new int[N];
        int[]LISR = new int[N];
        int max = 1;
        for(int i=0;i<N;i++){
            LISL[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]) LISL[i] = Math.max(LISL[i],LISL[j]+1);
            }
            max = Math.max(max,LISL[i]);
        }
        for(int i=N-1;-1<i;i--){
            LISR[i] = 1;
            for(int j=N-1;i<j;j--){
                if(arr[j]<arr[i]) LISR[i] = Math.max(LISR[i],LISR[j]+1);
            }
            max = Math.max(max,LISR[i]);
        }
        for(int i=0;i<N;i++){
            int tmp = (LISL[i] + LISR[i])-1;
            max = Math.max(max,tmp);
        }
        System.out.println(max);
    }
}
