package October_second;


import java.util.*;
import java.io.*;

public class bj_21921_블로그_Silver_3 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=  new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[]arr = new int[N];
		st=  new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
	
	
		int max = 0;
		int cnt = 1;
		
		for(int i=0;i<X;i++) max+= arr[i];	
		
		int tmp=max;
		
		for(int i=1;i<=N-X;i++) {
			
			tmp -= arr[i-1];
			tmp += arr[i+X-1];
			
			if(tmp>max) {
				cnt = 1;
				max = tmp;
			}else if(tmp==max) cnt++;
		
		}
		
		
		if(max==0) System.out.println("SAD");
		
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
		

		
	}

}
