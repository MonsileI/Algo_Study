package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_7490_0만들기_Gold_5 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            dfs(Integer.parseInt(br.readLine()),2,"1",1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int num,int depth,String sum,int result){

        if(depth==num+1){
           if(result==0) sb.append(sum).append("\n");
           return;
        }

        String newOne = sum + "+" + depth;
        int newResult = result + depth;
        dfs(num,depth+1,newOne,newResult);
        newOne = sum + "-" + depth;
        newResult -= depth;
        newResult -= depth;
        dfs(num,depth+1,newOne,newResult);

    }
}
