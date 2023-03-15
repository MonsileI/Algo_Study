package March_Second;

import java.util.*;
import java.io.*;
public class bj_3273_두수의합_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[N];

        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);

        int answer = 0;
        int goal = Integer.parseInt(br.readLine());
        int L = 0;
        int R = N - 1;
        while (L < R) {
                int sum = num[L] + num[R];
                if (sum == goal) answer++;

                if (sum <= goal) L++;
                else R--;


        }

        System.out.println(answer);


    }
}
