package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_1213_팰린드롬만들기_SIlver_3 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[]charr = str.toCharArray();
        Arrays.sort(charr);
        String prefix = "";
        String suffix="";
        Stack<Character> st = new Stack<>();
        int idx = 0;
        while(idx<charr.length){
            char ch = charr[idx];
            if(st.isEmpty()){
               st.add(ch);
               idx++;
            }else{
                char tmp = st.peek();
                if(tmp==ch) {
                    st.pop();
                    prefix = prefix+ch;
                    suffix = ch+suffix;
                    idx++;
                }else{
                    st.add(ch);
                    idx++;
                }

            }
        }

        if(charr.length%2==0 && st.isEmpty()) System.out.println(prefix+suffix);
        else if(charr.length%2==0 && !st.isEmpty()) System.out.println("I'm Sorry Hansoo");
        else if(charr.length%2==1 && st.size()%2==0) System.out.println("I'm Sorry Hansoo");
        else{
            while(!st.isEmpty()) prefix += st.pop();
            prefix += suffix;
            boolean flag = true;
            for(int i=0;i<prefix.length()/2;i++){
                char fch = prefix.charAt(i);
                char lch = prefix.charAt(prefix.length()-i-1);
                if(fch!=lch){
                    flag = false;
                    break;
                }
            }
            if(!flag) System.out.println("I'm Sorry Hansoo");
            else System.out.println(prefix);
        }
    }
}
