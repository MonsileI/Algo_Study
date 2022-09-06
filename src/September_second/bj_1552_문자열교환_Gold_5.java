package September_second;

import java.util.*;
import java.io.*;

public class bj_1552_문자열교환_Gold_5 {
	
	static String str;
	static int answer = 0;
	
	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
	}
	
	static void output() {
		System.out.println(answer);
	}

	static void calc() {
		
		Stack<Character> st = new Stack<>();
		
		for(char ch : str.toCharArray()) st.add(ch);
		
		while(!st.isEmpty()) {
			
			char ch = st.pop();
			
			if(!st.isEmpty() && ch==st.peek()) {
				st.pop();
			}else {
				st.pop();
				answer++;
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		input();
		calc();
		output();
		
	}

}
