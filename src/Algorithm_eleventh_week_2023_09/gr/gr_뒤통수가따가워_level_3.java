package Algorithm_eleventh_week_2023_09.gr;

import java.util.*;
import java.io.*;
public class gr_뒤통수가따가워_level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]ans = new int[N];
        for(int i=0;i<N;i++){
            ans[i] = stack.size();
            while(!stack.isEmpty()){
                if(stack.peek()<=arr[i]){
                    stack.pop();
                }else break;
            }
            stack.push(arr[i]);

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            if(i==N-1) sb.append(ans[i]);
            else sb.append(ans[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
