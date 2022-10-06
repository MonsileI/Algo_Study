package 삼성역량평가;

import java.io.*;
import java.util.*;


public class Solution_2382_미생물격리 {
	
	static class Virus{
		
		int i,j,w,d;

		public Virus(int i, int j, int w, int d) {
			super();
			this.i = i;
			this.j = j;
			this.w = w;
			this.d = d;
		}

		
	}
	
	static int N,M,K;
	static List<Virus> vList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1 ;t<=tc;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				vList.add(new Virus(a,b,c,d));
			}
			
		}
		
		
	}
}
