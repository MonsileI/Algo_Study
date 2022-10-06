package 삼성역량평가;

import java.util.*;
import java.io.*;

public class Solution_4008_숫자만들기 {

	//			+ - * /
	static int[]op;
	static int N;
	static int [] num;
	static int min,max;
	static int[]tmp;
	static boolean[]visited;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			
			N  = Integer.parseInt(br.readLine());
			num = new int[N];
			tmp = new int[N-1];
			visited = new boolean[N-1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			op = new int[N-1];
			
			for(int d=0;d<4;d++) {
				int cnt = Integer.parseInt(st.nextToken());
				 op[d] = cnt;
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine()," ");
			for(int d=0;d<N;d++) num[d] = Integer.parseInt(st.nextToken());
			
			calc(0);
			
		}
		
	}
	
	static void last() {
		
		System.out.println(Arrays.toString(tmp));
	}
	

	static void calc(int depth) {
		
		if(depth==N-1) {
			
			last();
		
			return;
		}
		
		
		
		for(int i=0;i<N-1;i++) {
			
			if(op[i]==0)continue;
			op[i]--;
			tmp[depth] = i;
			calc(depth+1);
			op[i]++;
			
		}
		
		
		
		
		
		
		
	}
}
