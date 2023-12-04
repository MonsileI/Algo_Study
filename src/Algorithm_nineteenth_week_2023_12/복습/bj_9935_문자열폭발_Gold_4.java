package Algorithm_nineteenth_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_9935_문자열폭발_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        Stack<Character> st = new Stack<>();
        int sizeA = a.length(); int sizeB = b.length();
        for(int i=0;i<sizeA;i++){
            st.push(a.charAt(i));

            if(sizeB<=st.size()){
                boolean flag = true;
                int idx = st.size()-1;
                for(int j=0;j<sizeB;j++){
                    if(st.get(idx--)!=b.charAt(sizeB-j-1)){
                        flag = false;
                        break;
                    }
                }
                if(flag) for(int j=0;j<sizeB;j++) st.pop();

            }
        }
        if(!st.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<st.size();i++)sb.append(st.get(i));
            System.out.println(sb.toString());
        }else{
            System.out.println("FRULA");
        }

    }
}
