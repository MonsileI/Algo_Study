package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_14247_나무자르기_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0L;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) answer += Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[]g = new int[N];
        for(int i=0;i<N;i++)g[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(g);
        for(int i=0;i<N;i++){
            answer += g[i] * i;
        }
        System.out.println(answer);
    }
}
