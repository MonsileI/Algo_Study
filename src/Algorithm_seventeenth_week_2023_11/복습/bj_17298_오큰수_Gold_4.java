package Algorithm_seventeenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_17298_오큰수_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        int[]ans = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
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
        while(!stack.isEmpty()) ans[stack.pop()] = -1;
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++)sb.append(ans[i]+" ");
        System.out.println(sb.toString());
    }
}
