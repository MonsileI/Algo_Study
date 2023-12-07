package Algorithm_twenty_week_2023_12.bj;
import java.util.*;
import java.io.*;
public class bj_17298_오큰수_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        int[]ans = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            if(stack.isEmpty()) stack.push(i);
            else{
                while(!stack.isEmpty()){
                    if(arr[i] > arr[stack.peek()]) ans[stack.pop()] = arr[i];
                    else break;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) ans[stack.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) sb.append(ans[i]+" ");
        System.out.println(sb.toString());
    }
}
