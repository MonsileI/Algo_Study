package 삼성역량평가;

import java.io.*;
import java.util.*;
/*
 2
 2
 4 3
 4
 2 3 5 10 
 * */
public class test {
	
	static int answer;
	static int N,arr[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			
			answer = Integer.MAX_VALUE;
			
			
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			
			Arrays.sort(arr);
			
			int comp = arr[N-1];
			boolean[]check = new boolean[N];
			
			check[N-1] = true;
			
			int day = 0;
			
			while(true) {
				
				boolean flag = true;
				
				for(int i=0;i<N;i++) {
					if(check[i]) continue;
					if(arr[i]!=comp) flag = false;
					if(arr[i]==comp) check[i] = true;
					
				}
				
				if(flag) break;
				
				if(arr[0]+3 <= comp) {
					arr[0] +=3;
					day += 2;
				}
				else if(arr[0]+(day%2)+1 <= comp) {
					arr[0] += (day%2) + 1;
					day++;
				}else {
					day++;
				}

				Arrays.sort(arr);
				
				
			}
	
			answer = day;
			System.out.println("#"+t+" "+answer);
		}
		
		
	}

}
