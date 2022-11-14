package November_second;

import java.util.*;
import java.io.*;

public class Solution_1486_장훈이의높은선반_D4 {

	static int N,M,arr[];
	static int answer;

	
	static void comb(int depth,int sum) {
	
		if(sum>=M) {
			answer = Math.min(answer, sum-M);			
			return;
		}
	
		if(depth==N) {
			if(sum>=M) {
				answer = Math.min(answer, sum-M);
			}
			return;				
		}
		int newSum = sum+arr[depth];
		comb(depth+1, newSum);
		comb(depth+1, sum);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=TC;t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			arr= new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			comb(0,0);
		
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
