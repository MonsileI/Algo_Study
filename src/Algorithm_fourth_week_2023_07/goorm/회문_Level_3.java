package Algorithm_fourth_week_2023_07.goorm;

import java.util.*;
import java.io.*;
public class 회문_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            String str = br.readLine();
            Stack<Character> st = new Stack<>();
            int size = str.length();
            for(int i=0;i<size;i++){
                char ch = str.charAt(i);
                if(st.isEmpty())st.push(ch);
                else{
                    if(st.peek()==ch)st.pop();
                    else st.push(ch);
                }
            }
            if(st.isEmpty()) sb.append(0).append("\n");
            else  if(st.size()==1) sb.append(1).append("\n");
            else{




            }

        }
        System.out.println(sb.toString());
    }
}
