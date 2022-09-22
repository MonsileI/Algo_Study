package September_fourth;

import java.io.*;
import java.util.*;

public class test2 {
	
	static int N , M;
	static int answer = 0;
	static int[]arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			calc(i);
		}
	
	}
	
	static void calc(int idx) {
		int L = 0;
		int R = 0;
		int sum = 0;
		while(true) {
			
			if(sum>=M) {
				answer= Math.min(answer,R-L);
				sum -= arr[L];
				L++;
			}else {
				if(R==N) break;
				else {
					sum += arr[R];
					R++;
				}
			}
		}
	}

}
