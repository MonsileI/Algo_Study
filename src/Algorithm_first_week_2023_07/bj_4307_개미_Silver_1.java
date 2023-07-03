package Algorithm_first_week_2023_07;

import java.io.*;
import java.util.*;
public class bj_4307_개미_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int min = 0;
            int max = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int i=0;i<M;i++) {
                int num = Integer.parseInt(br.readLine());
                //1이랑 가까운지 M이랑 가까운지 비교
                //더 가까운거의 max == min
                //더 먼거의 max == max
                min = Math.max(min,Math.min(num,Math.abs(num-N)));
                max = Math.max(max,Math.max(num,Math.abs(num-N)));

            }
            sb.append(min+" "+max).append("\n");
        }
        System.out.println(sb.toString());
    }
}
