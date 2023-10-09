package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1874_스택수열_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        Stack<Integer> stack = new Stack<>();
        OuterLoop:
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(!stack.isEmpty()){
                if(stack.peek()==num){
                    sb.append("-\n");
                    stack.pop();
                }else{
                    while(true) {
                        stack.push(idx++);
                        sb.append("+\n");
                        if(stack.peek()==num){
                            sb.append("-\n");
                            stack.pop();
                            break ;
                        }
                        if(N<idx){
                            flag = false;
                            break OuterLoop;
                        }
                    }
                }
            }else{
                while(true){
                    stack.push(idx++);
                    sb.append("+\n");
                    if(stack.peek()==num){
                        sb.append("-\n");
                        stack.pop();
                        break;
                    }
                    if(N<idx){
                        flag = false;
                        break OuterLoop;
                    }
                }
            }
        }
        if(!flag) System.out.println("NO");
        else System.out.println(sb.toString());
    }
}
