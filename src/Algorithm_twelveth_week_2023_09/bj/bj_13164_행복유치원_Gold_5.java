package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_13164_행복유치원_Gold_5 {
    static int N,K;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]tmp = new int[N-1];
        for(int i=0;i<N-1;i++) tmp[i] = arr[i+1] - arr[i];
        Arrays.sort(tmp);
        int ans = 0;
        for(int i=0;i<N-K;i++) ans += tmp[i];
        System.out.println(ans);
    }
}
