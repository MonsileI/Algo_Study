package November_first;

import java.util.*;
import java.io.*;

public class Main_16637_괄호추가하기_Gold_4 {

    static int n;
    static ArrayList<Integer>num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();
    static long answer = -987654321;
    public static void main(String[] args) throws Exception {
    	
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 n =Integer.parseInt(br.readLine());
      	String t = br.readLine();
	      for(int i=0; i<n; i++) {
	          if(i%2==0) {
	              num.add(t.charAt(i)-'0');
	          }
	          else {
	              op.add(t.charAt(i));
	          }
	      }
	      int start = num.get(0);
	      dfs(0,start);
	      System.out.println(answer);
    }
    
     public static void dfs(int depth, int sum) {
    
    	 
    	 if(depth>=op.size()) {
    		 
    		 answer = Math.max(answer, sum);
    		 
    		 return;
    	 }
    	 // none 괄호
    	 int one = cal(depth,sum,num.get(depth+1));
    	 dfs(depth+1,one);
    	 
    	 // 괄호 ㅇㅇ
    	 if(depth+1<op.size()) {
    		 int two = cal(depth+1,num.get(depth+1),num.get(depth+2));
    		 int result = cal(depth,sum,two);
    		 dfs(depth+2,result);
    	 }
    	 
         
    	 
    	 
    }
     public static int cal(int op_idx,int a, int b) {
         switch(op.get(op_idx)) {
         case '+':  return a+b;
         case '-':  return a-b;
         case '*':  return a*b;
         }
         return 0;
     }

 }


