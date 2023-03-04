package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_11497_통나무건너뛰기_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int [] tmp = new int[N];
            //1 3 5 4 2
            //0   N
            //1 3 5 6 4 2
            //0   N-1
            int idx=0;
            if(N%2==0) idx = 1;
            else idx = 0;

            int tidx = 0;
            while(true){
                if(N<idx) break;
                tmp[tidx] = arr[idx];
                idx += 2;
                tidx++;
            }
            idx = N-2;
            while(true){

                if(idx<0) break;
                if(N-1<tidx) break;
                tmp[tidx] = arr[idx];
                idx -= 2;
                tidx++;

            }
            int max = 0;
            for(int i=1;i<N;i++){
                max = Math.max(max,Math.abs(tmp[i]-tmp[i-1]));
            }
            max = Math.max(max,Math.abs(tmp[0]-tmp[N-1]));
            sb.append(max).append("\n");


        }


        System.out.println(sb.toString());
    }
}
