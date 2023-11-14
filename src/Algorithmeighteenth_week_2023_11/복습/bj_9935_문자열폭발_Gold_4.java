package Algorithmeighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_9935_문자열폭발_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int N = str.length();
        int M = bomb.length();
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            stack.push(ch);
            if(M<=stack.size()){
                boolean flag = true;
                int idx = stack.size()-1;
                for(int j=0;j<M;j++){
                   if(stack.get(idx--)!=bomb.charAt(M-j-1)){
                       flag = false;
                       break;
                   }
                }
                if(flag){
                    for(int j=0;j<M;j++) stack.pop();
                }
            }
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<stack.size();i++) sb.append(stack.get(i));
            System.out.println(sb.toString());
        }

    }
}