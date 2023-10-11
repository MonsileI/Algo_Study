package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_9935_문자열폭발_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sSize = str.length();
        String comp = br.readLine();
        int cSize = comp.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<sSize;i++){
            char ch = str.charAt(i);
            stack.push(ch);

            if(stack.size()>=cSize){
                boolean flag = true;
                for(int j=0;j<cSize;j++){
                    char ch1 = comp.charAt(j);
                    char ch2 = stack.get(stack.size()-cSize+j);
                    if(ch1!=ch2){
                        flag = false;
                        break;
                    }
                }
                if(flag) for(int j=0;j<cSize;j++) stack.pop();
            }
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) sb.append(stack.get(i));
            System.out.println(sb.toString());
        }
    }
}
