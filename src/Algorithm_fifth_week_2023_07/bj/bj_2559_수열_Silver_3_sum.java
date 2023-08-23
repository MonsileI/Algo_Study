package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_2559_수열_Silver_3_sum {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int[]sumArr = new int[N];
        int sum = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            sumArr[i] = sum;
        }
        int answer = sumArr[K-1];
        for(int i=K;i<N;i++) {
            answer = Math.max(answer,sumArr[i]-sumArr[i-K]);
        }

        System.out.println(answer);

    }
}
