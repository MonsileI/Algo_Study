package November_second;

import java.util.*;
import java.io.*;

public class bj_1027_고층건물_Gold_4 {
	static int N;
	static double[]arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new double[N];
		
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		for(int i=0;i<N;i++) {
			int tmp = check(i);
			answer = Math.max(answer, tmp);
		}
		System.out.println(answer);
	
	
	
	}
	
	static int check(int idx) {
		
		int answer=0;
		double tmp=0;
		for(int i=idx;i>-1;i--) {
		double gack = (arr[idx]- arr[i]) / (idx-i);	
			if(i==idx-1) {
				tmp = gack;
				answer++;
			}
			if(gack<tmp) {
				tmp = gack;
				answer++;
			}
		}
		for(int i=idx;i<N;i++) {
			double gack = (arr[i]-arr[idx]) / (i-idx);
			if(i==idx+1) {
				tmp = gack;
				answer++;
			}
			if(gack>tmp) {
				tmp = gack;
				answer++;
			}
			
		}
		return answer;
		
	}
}
