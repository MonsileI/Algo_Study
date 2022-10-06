package September_third;

import java.util.*;
import java.io.*;

public class bj_2003_수들의합2_silver_4 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[]arr = new int[N];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		System.out.println(Arrays.toString(arr));
		
		int R=0;
		
		int sum = 0;
		
			
			
		for(int i=0;i<N;i++) {
			while(sum<M && R < N) {
				sum += arr[R++];
			}
			
			if(sum==M) answer++;
			
			sum -= arr[i];
		}
		
		
		System.out.println(answer);
	}

}
