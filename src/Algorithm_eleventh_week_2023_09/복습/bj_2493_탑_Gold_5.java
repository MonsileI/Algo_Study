package Algorithm_eleventh_week_2023_09.복습;

import java.util.*;
import java.io.*;
public class bj_2493_탑_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]ans = new int[N];
        for(int i=0;i<N;i++){
            if(stack.isEmpty()) ans[i] = 0;
            else{
                while(!stack.isEmpty()){
                    if(arr[i]<arr[stack.peek()]) {
                        ans[i] = stack.peek()+1;
                        break;
                    }
                    stack.pop();
                }
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans) sb.append(i+" ");
        System.out.println(sb.toString());
    }
}
