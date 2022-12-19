package December_third;

import java.util.*;
import java.io.*;


public class bj_7579_앱_Gold_3 {
	
	static int M,arr[][],N,answer;

	static void comb(int depth, int sum,int start,int cost) {
		
		if(M<sum) return;
		
		if(M==sum) {
			answer = Math.min(answer, cost);
			return;
		}
		if(answer<=cost) return;
		
		
		for(int i=0;i<N;i++) {
			
			int newSum = sum + arr[0][depth];
			int newCost = cost + arr[1][depth];		
			comb(depth+1,newSum,i+1,newCost);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[2][N];
		answer = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) arr[0][i] = Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) arr[1][i] = Integer.parseInt(st.nextToken());	
		
		comb(0,0,0,0);
		
		System.out.println(answer);
		
	}
}
