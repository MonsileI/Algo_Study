package Algorithm_twenty_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_10799_쇠막대기_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            if(ch=='(') stack.push(ch);
            else{
                stack.pop();
                if(str.charAt(i-1)=='(') answer += stack.size();
                else answer++;

            }
        }
        System.out.println(answer);
    }
}
