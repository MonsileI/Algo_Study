package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_10942_팰린드롬_Gold_4_re {


    static int go(int S,int E){

        if(dp[S][E]!=-1) return dp[S][E];

        if(numArr[S]!=numArr[E]) return 0;

        if(S==E || S+1==E) return 1;

        return go(S+1,E-1);

    }

    static int N;
    static int []numArr;
    static int [][]dp;

    public static void main(String[] args) throws Exception{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      numArr = new int[N+1];
      dp = new int[N+1][N+1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=1;i<=N;i++){
          numArr[i] = Integer.parseInt(st.nextToken());
          Arrays.fill(dp[i],-1);
      }
      StringBuilder sb = new StringBuilder();
      int Q = Integer.parseInt(br.readLine());
      for(int q=0;q<Q;q++){
          st = new StringTokenizer(br.readLine()," ");
          int S = Integer.parseInt(st.nextToken());
          int E = Integer.parseInt(st.nextToken());
          sb.append(go(S,E)).append("\n");
      }
        System.out.println(sb.toString());

    }
}
