package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_22115_창영이와커피_Gold_5 {
    static int N,K,arr[];
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        answer = 987654321;
        comb(0,0,0);
        System.out.println(answer==987654321 ? -1 : answer);

    }
    static void comb(int start,int depth,int sum){

        if(K<sum) return;

        if(answer<=depth) return;

        if(sum==K) {
            answer = Math.min(answer,depth);
            return;
        }

        if(depth==N){
            if(sum==K) answer = Math.min(answer,depth);
            return;
        }

        for(int i=start;i<N;i++){
            int newOne = sum + arr[i];
            comb(i+1,depth+1,newOne);
        }
    }
}
