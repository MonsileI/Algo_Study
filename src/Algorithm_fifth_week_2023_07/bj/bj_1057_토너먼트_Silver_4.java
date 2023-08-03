package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_1057_토너먼트_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken()); int s = Integer.parseInt(st.nextToken());
        int answer = 0;
        while(f!=s){
            f = f/2 + f%2;
            s = s/2 + s%2;
            answer++;
        }
        System.out.println(answer);
    }
}
