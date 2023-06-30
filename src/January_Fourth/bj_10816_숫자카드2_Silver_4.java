package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_10816_숫자카드2_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)) sb.append(map.get(num)+" ");
            else sb.append(0+" ");
        }
        System.out.println(sb.toString());
    }
}
