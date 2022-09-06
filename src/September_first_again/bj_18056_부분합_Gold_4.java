package September_first_again;

import java.util.*;
import java.io.*;

public class bj_18056_부분합_Gold_4 {

	static int N,S;
	static int answer = Integer.MAX_VALUE/2;
	static int[] arr;
	
	static void input() throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
	}
	
	static void output() {
		System.out.println(answer);
	}
	
	static void calc() {
		
		
		int L = 0;
		int R = 0;
		int sum = 0;
		
		while(true) {
			
			if(sum>=S) {
				answer = Math.min(answer, R-L);
				sum -= arr[L++];
			}else {
				if(R==N) return;
				else sum += arr[R++];
			}
			
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		input();
		calc();
		output();
	}
}
