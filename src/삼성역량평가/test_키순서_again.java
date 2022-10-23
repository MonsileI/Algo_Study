package 삼성역량평가;

import java.util.*;
import java.io.*;

public class test_키순서_again {
	
	static int N , M;
	static boolean[][]adj;
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		adj = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from][to] = true;
		}
		
		
		for(int k=1;k<N+1;k++) {
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					adj[i][j] = adj[i][j] || (adj[i][k] && adj[k][j]);
				}
			}
		}
		
		int res=0;
		
		outerLoop:
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(i==j) continue;
				if(!adj[i][j] && !adj[j][i]) continue outerLoop;
			}
			res++;
		}
		System.out.println(res);
		
	}

}
