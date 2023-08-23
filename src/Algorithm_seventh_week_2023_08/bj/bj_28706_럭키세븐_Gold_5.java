package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_28706_럭키세븐_Gold_5 {
    static int N;
    static String[]str;
    static String answer;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            N = Integer.parseInt(br.readLine());
            str = new String[N];
            for(int i=0;i<N;i++) str[i] = br.readLine();
            answer = "UNLUCKY";
            flag = false;
            comb(1,0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void comb(int sum,int depth){
        if(flag) return;
        if(depth==N){
            if(sum%7==0) {
                answer= "LUCKY";
                flag = true;
            }
            return;
        }

        int newOne = sum;
        if(str[depth].charAt(0)=='+') newOne += Integer.parseInt(str[depth].charAt(2)+"");
        else newOne *= Integer.parseInt(str[depth].charAt(2)+"");
        comb(newOne,depth+1);
        newOne = sum;
        if(str[depth].charAt(4)=='+') newOne += Integer.parseInt(str[depth].charAt(6)+"");
        else newOne *= Integer.parseInt(str[depth].charAt(6)+"");
        comb(newOne,depth+1);
    }
}
