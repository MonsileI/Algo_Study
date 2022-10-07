package DP;

import java.io.*;
import java.util.*;

public class Solution_3307_최장증가부분수열_D3 {

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int []arr = new int[N];
			int []range = new int[N];
			for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
	
			int max = 0;
			for(int i=0;i<N;i++) {
				range[i] = 1;
				for(int j=0;j<i;j++) {
					if(arr[j] < arr[i] && range[i] < range[j] + 1) {
						range[i] = range[j]+1;
					}
				}
				max = Math.max(max, range[i]);
			}
			
		
			System.out.println("#"+t+" "+max);
			
		}
		
	}
}
