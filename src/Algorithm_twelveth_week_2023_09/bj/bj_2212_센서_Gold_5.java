package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_2212_센서_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int answer = 0;
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        if(N<=K) answer = 0;
        else {
            Arrays.sort(arr);
            int[] tmp = new int[N - 1];
            for (int i = 0; i < N - 1; i++) {
                tmp[i] = arr[i + 1] - arr[i];
            }
            Arrays.sort(tmp);
            for (int i = 0; i < N - K; i++) {
                answer += tmp[i];
            }
        }
        System.out.println(answer);
    }
}
