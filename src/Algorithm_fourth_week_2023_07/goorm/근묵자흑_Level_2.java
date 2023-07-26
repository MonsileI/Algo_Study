package Algorithm_fourth_week_2023_07.goorm;

import java.util.*;
import java.io.*;
public class 근묵자흑_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int temp = N-K;
        if(N<=K) System.out.println(1);
        else if(temp%(K-1)!=0) System.out.println(temp/(K-1) + 2);
        else System.out.println(temp/(K-1)+1);
    }
}
