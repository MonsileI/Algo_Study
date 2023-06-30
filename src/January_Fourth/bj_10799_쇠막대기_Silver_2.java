package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_10799_쇠막대기_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int i=0;i<size;i++){
            char ch = str.charAt(i);
            if(ch=='(') stack.push(ch);
            else{
                if (str.charAt(i-1)=='(') {
                    stack.pop();
                    answer += stack.size();
                }else{
                    stack.pop();
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
