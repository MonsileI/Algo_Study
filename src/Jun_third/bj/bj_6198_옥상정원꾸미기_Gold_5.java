package Jun_third.bj;

import java.util.*;
import java.io.*;
public class bj_6198_옥상정원꾸미기_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        long answer = 0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            while(!st.isEmpty()){
                int tmp = st.peek();
                if(num < tmp) break;
                else st.pop();
            }
            answer += st.size();
            st.push(num);
        }
        System.out.println(answer);
    }
}