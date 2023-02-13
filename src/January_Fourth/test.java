package January_Fourth;

import java.util.*;
import java.io.*;

public class test {

    static int []tmp = {1,2,3};
    static int answer;
    static void dfs(int t,int sum){

        if(t==sum){
            answer++;
            return;
        }
        if(t<sum) return;

        for(int i=0;i<3;i++){
            int newOne = sum + tmp[i];
            dfs(t,newOne);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            answer = 0;
            int num = Integer.parseInt(br.readLine());
            dfs(num,0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
