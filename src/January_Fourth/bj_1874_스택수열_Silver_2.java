package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_1874_스택수열_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[]oriArr = new int[N];
        int[]sortArr = new int[N];
        int num = 0;
        for(int i=0;i<N;i++){
            num = Integer.parseInt(br.readLine());
            oriArr[i] = sortArr[i] = num;
        }
        Arrays.sort(sortArr);
        num = 0;
        int cnt = 0;
        while(cnt<N){

            if(stack.isEmpty()){
                if(N<=num) break;
                stack.push(sortArr[num]);
                num++;
                sb.append('+').append("\n");
            }else{
               if(stack.peek()==oriArr[cnt]){
                   cnt++;
                   stack.pop();
                   sb.append('-').append("\n");
               }else{
                   if(N<=num) break;
                   stack.push(sortArr[num]);
                   num++;
                   sb.append('+').append("\n");
               }
            }

        }

        if(!stack.isEmpty()) System.out.println("NO");
        else System.out.println(sb.toString());


    }
}
