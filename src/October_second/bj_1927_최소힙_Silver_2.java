package October_second;

import java.util.*;
import java.io.*;

public class bj_1927_최소힙_Silver_2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
				
			if(n==0) {
				if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
				else sb.append("0").append("\n");
			}else {
				pq.offer(n);
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
}
