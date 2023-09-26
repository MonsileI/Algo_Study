package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_4949_균형잡힌세상_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            int size = str.length();
            Stack<Character> st = new Stack<>();
            boolean flag = true;
            for(int i=0;i<size;i++){
                char ch = str.charAt(i);
                if(ch=='('||ch=='[') {
                    st.push(ch);
                }else if(ch==')'||ch==']'){
                    if(st.isEmpty()){
                        sb.append("no\n");
                        flag = false;
                        break;
                    }
                    if(ch==')'&&st.peek()=='('){
                        st.pop();
                        continue;
                    }else if(ch==']'&&st.peek()=='['){
                        st.pop();
                        continue;
                    }else {
                        sb.append("no\n");
                        flag= false;
                        break;
                    }
                }
            }

            if(flag){
                if(st.isEmpty()){
                    sb.append("yes\n");
                }else{
                    sb.append("no\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
