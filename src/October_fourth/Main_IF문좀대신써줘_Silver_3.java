package October_fourth;

import java.util.*;
import java.io.*;

public class Main_IF문좀대신써줘_Silver_3 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] nickArr= new String[N];
		int[] powerArr= new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			nickArr[i] = st.nextToken();
			powerArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			
			int num = Integer.parseInt(br.readLine());
			int start =0;
			int end = N-1;
			int mid = 0;
			
			while(start<=end) {
				mid = (start+end)/2;
				if(num>=powerArr[mid]) start = mid+1;
				else end = mid-1;
				
			}
			System.out.println(num);
			System.out.println(mid);
			System.out.println(nickArr[mid]);
			sb.append(nickArr[mid]).append("\n");
			System.out.println("==============");
		}
		System.out.println("===========");
		System.out.println(sb.toString());
	}
	
}
