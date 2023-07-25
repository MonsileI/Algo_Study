package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1182_부분수열의합_Silver_2 {
    static int[]arr;
    static int N,S;
    static int answer;
    static void comb(int depth,int start,int sum){

        if(sum==S)answer++;

        if(depth==N) return;


        for(int i=start;i<N;i++){
            int newOne = sum + arr[i];
            comb(depth+1,i+1,newOne);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        answer = 0;
        for(int i=0;i<N;i++) comb(i+1,i+1,arr[i]);
        System.out.println(answer);
    }

}
