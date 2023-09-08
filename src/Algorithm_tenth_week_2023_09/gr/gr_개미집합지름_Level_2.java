package Algorithm_tenth_week_2023_09.gr;

import java.util.*;
import java.io.*;
public class gr_개미집합지름_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int L = 0;
        int R = 0;
        int answer = 0;
        while (R < N && L < N) {
            if (arr[R] - arr[L] <= M) {
                answer = Math.max(answer, R - L + 1);
                R++;
            } else L++;

        }
        System.out.println(N-answer);
    }
}
