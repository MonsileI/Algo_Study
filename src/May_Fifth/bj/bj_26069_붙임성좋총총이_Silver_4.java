package May_Fifth.bj;

import java.util.*;
import java.io.*;
public class bj_26069_붙임성좋총총이_Silver_4 {
    static int N;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String from = st.nextToken();
            String to = st.nextToken();
            if (from.equals("ChongChong") && !map.containsKey(to)) {map.put(to, 0); map.put(from,0);}
            else if(to.equals("ChongChong") && !map.containsKey(from)) {map.put(to, 0); map.put(from,0);}
            else if (map.containsKey(from) && !map.containsKey(to)) map.put(to, 0);
            else if (map.containsKey(to) && !map.containsKey(from)) map.put(from, 0);
        }
        System.out.println(map.size());
    }
}
