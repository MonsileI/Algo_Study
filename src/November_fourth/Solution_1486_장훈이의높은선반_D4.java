package November_fourth;

import java.util.*;
import java.io.*;

public class Solution_1486_장훈이의높은선반_D4 {

	static int N;
	static int B;
	static int[]arr;
	static int answer;
	
	
	
	static void comb(int depth,int sum) {
		
	
		if(depth==N) {
			if(B<=sum) answer = Math.min(answer, sum-B);
			return;
		}
		
		if(B<=sum) {
			answer = Math.min(answer, sum-B);
			return;
		}
		
		
		comb(depth+1,sum+arr[depth]);
		comb(depth+1,sum);
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			answer = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			comb(0,0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
