package Algorithm_fifteenth_week_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_인공지능청소기_Level_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<N;t++){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int man = Math.abs(i)+Math.abs(j);
            if(num<man) sb.append("NO\n");
            else{
                if((num - man)%2==0)sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
}
