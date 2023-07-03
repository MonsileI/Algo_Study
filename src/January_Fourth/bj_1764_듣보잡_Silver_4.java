package January_Fourth;

import java.io.*;
import java.util.*;

public class bj_1764_듣보잡_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        String[]d = new String[N];
        String[]b = new String[M];
        for(int i=0;i<N;i++) d[i] = br.readLine();
        for(int i=0;i<M;i++) b[i] = br.readLine();
        Map<String,Integer> map = new TreeMap<>();
        Arrays.sort(d); Arrays.sort(b);
        StringBuilder sb = new StringBuilder();
        int cnt =0;
        for(int i=0;i<N;i++) map.put(d[i],0);
        for(int i=0;i<M;i++) {if(map.containsKey(b[i])) {sb.append(b[i]).append("\n");cnt++;}}
        System.out.println(cnt);
        System.out.println(sb.toString());

    }
}
