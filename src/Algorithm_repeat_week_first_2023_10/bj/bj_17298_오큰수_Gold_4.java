package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_17298_오큰수_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int[]ans = new int[N];
        for(int i=0;i<N;i++){
            if(stack.isEmpty()) stack.push(i);
            else{
                while(!stack.isEmpty()){
                    if(arr[stack.peek()]<arr[i]) ans[stack.pop()] = arr[i];
                    else break;
                }
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) ans[stack.pop()] = -1;
        for(int i=0;i<N;i++) sb.append(ans[i]+" ");
        System.out.println(sb.toString());
    }
}
