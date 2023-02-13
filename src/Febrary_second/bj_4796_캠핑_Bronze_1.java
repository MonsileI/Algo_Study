package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_4796_캠핑_Bronze_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int L =0;
        int P =0;
        int V =0;
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int r = 1;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            L = Integer.parseInt(st.nextToken()); //날수
            P = Integer.parseInt(st.nextToken()); //붙어있는 날
            V = Integer.parseInt(st.nextToken()); //휴가수

            if(L==0&&P==0&&V==0) break;

            int tmp = V/P;
            int other = V%P;
            int answer = L*tmp + other;
            if(L<other) {
                answer -= other;
                answer += L;
            }
            sb.append("Case "+r+": "+answer).append("\n");
            r++;
        }
        System.out.println(sb.toString());
    }
}
