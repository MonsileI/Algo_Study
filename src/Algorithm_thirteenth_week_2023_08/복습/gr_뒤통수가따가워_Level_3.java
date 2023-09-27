package Algorithm_thirteenth_week_2023_08.복습;

import java.util.*;
import java.io.*;

public class gr_뒤통수가따가워_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int[]ans = new int[N];
        for(int i=0;i<N;i++){
            ans[i] = stack.size();
            while(!stack.isEmpty()){
                if(stack.peek()<=arr[i]) stack.pop();
                else break;
            }
            stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N;i++){
            if(i==N-1) {
                sb.append(ans[i]);
                break;
            }
            sb.append(ans[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
