package October_second;

import java.io.*;
import java.util.*;

public class bj_9655_돌게임_Silver_5_2 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String answer = "";
		int check=0;
		//홀수면 상근 짝수면 창영
		while(true) {
			
			check++;

			if(N-3==0) break;
			else if(N-2==0) N--;
			else if(N-1==0) break;
			else N-= 3;
			
		}
		
		System.out.println(check%2==1 ? "SK" : "CY");
				
	}

}
