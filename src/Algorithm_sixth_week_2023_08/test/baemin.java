package Algorithm_sixth_week_2023_08.test;

import java.util.*;
public class baemin {
    public static void main(String[] args) {
        String str = "helloolleh";
        Stack<Character> st = new Stack<>();
        int size = str.length();
        for(int i=0;i<size;i++){
            if(!st.isEmpty()&&st.peek()==str.charAt(i)) st.pop();
            else st.push(str.charAt(i));
        }
        System.out.println(st);


    }
}
