package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_9012_괄호_Silver_4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            Stack<Character> st = new Stack<>();
            String str = br.readLine();
            int size = str.length();
            boolean flag = true;
            InnerLoop:
            for(int i=0;i<size;i++){
                char ch = str.charAt(i);
                if(ch=='(') st.push(ch);
                else {
                    if(st.isEmpty()) {
                        sb.append("NO").append("\n");
                        flag = false;
                        break InnerLoop;
                    }else st.pop();
                }
            }
            if(flag){
                if(st.isEmpty())sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
