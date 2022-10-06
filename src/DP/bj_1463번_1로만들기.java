package DP;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1463번_1로만들기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int X = sc.nextInt();
		
		//임의의 숫자가 만들어질 수 있는 경우의 수
		int[]DP = new int[X+1];
		//3을 곱하거나 2를 곱하거나 1를 더한다.
		
		
		
		DP[0] = 0; //0에 대한 최적해는 0
		DP[1] = 0; //1에 대한 최적해는 0
	
		for(int i=2;i<=X;i++) {
			int min = DP[i-1]+1;
			if(i%2==0) min = Math.min(min, DP[i/2]+1);
			if(i%3==0) min = Math.min(min, DP[i/3]+1);
			DP[i] = min;
		}
		
		
		System.out.println(DP[X]);
	}

}
