package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1904_01타일_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        int answer = 0;
        if(N<3) answer = N;
        else{
            arr[0] = 0; arr[1] = 1;arr[2] = 2;
            for(int i=3;i<N+1;i++) arr[i] = (arr[i-1] + arr[i-2])%15746;
            answer = arr[N];
        }
        System.out.println(answer);
    }
}
