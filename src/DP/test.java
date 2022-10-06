package DP;

import java.util.*;

public class test {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		int[]DP = new int[X+1];
		
		DP[0] = 0;
		DP[1] = 0;
		
		for(int i=2;i<=X;i++) {
			
			int min = DP[i-1]+1;
			
			if(i%2==0) min = Math.min(DP[i/2]+1, min);
			if(i%3==0) min = Math.min(DP[i/3]+1, min);
			
			DP[i] = min;
			
		}
		
		
		System.out.println(Arrays.toString(DP));
		System.out.println(DP[X]);
	}

}
