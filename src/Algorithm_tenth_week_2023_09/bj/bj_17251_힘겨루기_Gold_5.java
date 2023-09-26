package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_17251_힘겨루기_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int L = 0; int R = 0;
        int []arr1= new int[N];
        int []arr2 = new int[N];
        int Lmax = 0;
        int Rmax = 0;
        for(int i=0;i<N;i++){
            Lmax = Math.max(Lmax,arr[i]);
            Rmax = Math.max(Rmax,arr[N-i-1]);
            arr1[i] = Lmax;
            arr2[N-i-1] = Rmax;
        }
        int lCnt = 0;
        int rCnt = 0;
        for(int i=1;i<N;i++){
            if(arr1[i-1]==arr2[i]) continue;
            if(arr1[i-1]>arr2[i]){
                lCnt++;
            }else{
                rCnt++;
            }
        }
        if(lCnt>rCnt) System.out.println('R');
        else if(lCnt<rCnt) System.out.println('B');
        else System.out.println('X');
    }
}
