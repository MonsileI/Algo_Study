package Algorithm_repeat_week_first_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_구름공방_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long s = 0;
        long[]arr = new long[N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());
            if(s<start) s = start;
            arr[i] = s+end;
            s = arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)sb.append(arr[i]+"\n");
        System.out.println(sb.toString());
    }
}
