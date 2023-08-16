package Algorithm_seventh_week_2023_08.gr;

import java.io.*;
import java.util.*;
public class gr_UIUX디자이너_Level_2 {



    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[N+1];
        int maxValue = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int k = Integer.parseInt(st.nextToken());
            for(int j=0;j<k;j++){
                int num = Integer.parseInt(st.nextToken());
                arr[num]++;
                maxValue = Math.max(maxValue,arr[num]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=N;-0<i;i--){
            if(arr[i]==maxValue)sb.append(i+" ");
        }
        System.out.println(sb.toString());





    }
}
