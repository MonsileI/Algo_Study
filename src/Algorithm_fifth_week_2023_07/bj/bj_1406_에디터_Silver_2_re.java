package Algorithm_fifth_week_2023_07.bj;

import java.io.*;
import java.util.*;
public class bj_1406_에디터_Silver_2_re {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        int size = str.length();
        for(int i=0;i<size;i++) left.push(str.charAt(i));
        int TC = Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            String order = br.readLine();
            if(order.charAt(0)=='P') left.push(order.charAt(2));
            else{
                switch (order.charAt(0)){
                    case 'L': if(!left.isEmpty()){
                        char ch = left.pop();;
                        right.push(ch);
                    }
                        break;
                    case 'D': if(!right.isEmpty()) {
                        char ch = right.pop();
                        left.push(ch);
                    }
                        break;
                    case 'B': if(!left.isEmpty()) {
                        left.pop();
                    }
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty())right.push(left.pop());
        while(!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb.toString());
    }
}
