package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2195_문자열복사_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] f = br.readLine().toCharArray();
        String s = br.readLine();
        int size = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<size;i++) st.push(s.charAt(i));
        size = f.length-1;
        int answer = 0;
        while(!st.isEmpty()){
            char ch = st.peek();
            if(ch!=f[size]) {
                size--;
                if(size==-1) size = f.length-1;
            }else{
                answer++;
                ch = st.pop();
                if(ch==f[size]){
                    while(ch!=f[size]){
                        answer++;
                        ch = st.pop();
                    }
                }
                size--;
                if(size==-1){
                    size = f.length-1;
                    continue;
                }
                ch = st.pop();
                while(ch==f[size]){
                    ch = st.pop();
                    size--;
                    if(size==-1){
                        size = f.length-1;
                        break;
                    }
                }
                }
            }
        System.out.println(answer);
    }

}
