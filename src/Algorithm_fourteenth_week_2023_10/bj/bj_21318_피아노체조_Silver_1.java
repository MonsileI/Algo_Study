package Algorithm_fourteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_21318_피아노체조_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        int[]sum = new int[N];
        StringTokenizer st=  new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int tmp = arr[0];
        for(int i=1;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1];
            if(arr[i]<tmp) sum[i]++;
            tmp = arr[i];
        }
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;
            sb.append(sum[s]-sum[f]+"\n");
        }
        System.out.println(sb.toString());
    }
}
