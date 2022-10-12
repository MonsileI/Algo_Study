package October_first;

import java.io.*;
import java.util.*;
public class bj_2467_용액_Gold_5 {
	
	public static void main(String[] args) throws Exception {
		
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		
		int min = Integer.MAX_VALUE;
		
		int first =0;
		int second = 0;
		
		for(int i=0;i<N;i++) {
			
			int start =i+1;
			int end = N-1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				
				int sum = arr[i] + arr[mid];
				
				if(Math.abs(sum) < min) {
					first = arr[i];
					second = arr[mid];
					min = Math.abs(sum);
				}
				
				if(sum<0) {
					start = mid+1;
					
				}else {
					end = mid-1;
				}
				
				System.out.println(start + " : "+ end);
			}
		}
		
		System.out.println(first + " " + second);
	}

}
