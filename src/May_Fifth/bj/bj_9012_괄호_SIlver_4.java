package May_Fifth.bj;

import java.util.*;
import java.io.*;
public class bj_9012_괄호_SIlver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            String str = br.readLine();
            Stack<Character> st = new Stack<>();
            int size = str.length();
            boolean flag = true;

            for(int i=0;i<size;i++){
                char ch = str.charAt(i);
                if(st.isEmpty()){
                    if(ch==')') {flag = false; break;}
                    else st.push(ch);
                }else{
                    if(ch!=st.peek()) st.pop();
                    else st.push(ch);
                }
            }
            if(!st.isEmpty()) flag = false;
            if(flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}
