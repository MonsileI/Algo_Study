package Algorithm_fourteenth_week_2023_10.bj;

import java.io.*;
public class bj_1342_행운의문자열_Silver_1 {
    static int N;
    static int[]arr;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = str.length();
        arr = new int[26];
        for(int i=0;i<N;i++) arr[str.charAt(i)-'a']++;
        dfs(0,-1);
        System.out.println(answer);
    }
    static void dfs(int depth,int last){
        if(depth==N){
            answer++;
            return;
        }
        for(int i=0;i<26;i++){
            if(arr[i]==0) continue;
            if(i!=last){
                arr[i]--;
                dfs(depth+1,i);
                arr[i]++;
            }
        }
    }
}
