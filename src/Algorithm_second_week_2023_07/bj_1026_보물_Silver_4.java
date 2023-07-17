package Algorithm_second_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1026_보물_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]a = new int[N];
        Integer[]b = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) b[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });
        for(int i=0;i<N;i++) answer += (a[i]*b[i]);
        System.out.println(answer);
    }
}
