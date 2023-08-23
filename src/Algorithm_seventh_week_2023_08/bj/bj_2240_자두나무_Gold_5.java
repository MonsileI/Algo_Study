package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2240_자두나무_Gold_5 {
    static int T,W;
    static int[]arr;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        T = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken());
        arr= new int[T];
        for(int i=0;i<T;i++) arr[i] = Integer.parseInt(br.readLine());
        dfs(0,0,1);
        System.out.println(answer);
    }
    static void dfs(int depth,int sum,int loc){

        if(depth==T-1){
            answer = Math.max(answer,sum);
            return;
        }

            if(arr[depth]==1) dfs(depth+1,sum+1,1);
            else dfs(depth+1,sum,1);

            if(arr[depth]==2)dfs(depth+1,sum+1,2);
            else dfs(depth+1,sum,2);

    }
}
