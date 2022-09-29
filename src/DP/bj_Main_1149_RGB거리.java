package DP;

import java.util.Scanner;

public class bj_Main_1149_RGB거리 {

	static final int R=0;
	static final int G=1;
	static final int B=2;
	
	static int[][]cost, DP;
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		cost  = new int[N][3];
		DP = new int[N][3];
		for(int i=0;i<N;i++) {
		
			cost[i][R] = scan.nextInt();
			cost[i][G] = scan.nextInt();
			cost[i][B] = scan.nextInt();
		}
		
		DP[0][R] = cost[0][R];
		DP[0][G] = cost[0][G];
		DP[0][B] = cost[0][B];
		
		
	   
		System.out.println(Math.min(calc(N-1,R), Math.min(calc(N-1,G), calc(N-1,B))));
		
		
	}
	
	static int calc(int N, int color) {
		
		
		if(DP[N][color] == 0) {
			
			if(color == R) {
				DP[N][R] = Math.min(calc(N-1,G), calc(N-1,B)) + cost[N][R];
			}
			else if(color == G) {
				DP[N][G] = Math.min(calc(N-1,R), calc(N-1,B)) + cost[N][G];
			}
			else {
				DP[N][B] = Math.min(calc(N-1,R), calc(N-1,G)) + cost[N][B];
			}
		}
		
		return DP[N][color];
	}
}
