package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14002_가장긴증가하는부분수열4_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N];
        int[]tmp = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        StringBuilder sb = new StringBuilder(max+"\n");
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1;-1<i;i--){
            if(dp[i]==max){
                stack.push(arr[i]);
                max--;
            }
        }

        while(!stack.isEmpty()) sb.append(stack.pop()+" ");
        System.out.println(sb.toString());
    }
}
