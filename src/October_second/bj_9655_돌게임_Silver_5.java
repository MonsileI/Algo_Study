package October_second;

import java.io.*;
import java.util.*;

public class bj_9655_돌게임_Silver_5 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String answer = "";
		int check= N/3;
		
		if(N%3==1) check++;
		
		//홀수면 상근 짝수면 창영

		System.out.println(check%2==1 ? "SK" : "CY");
		
	}

}
