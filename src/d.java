
import java.util.*;
import java.io.*;

public class d {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean [][] adj = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int	to = Integer.parseInt(st.nextToken());
			adj[from][to] = true;
		}
		
		for(int k=1;k<N+1;k++) {
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					adj[i][j] = adj[i][j] || (adj[i][k] && adj[k][j]);
				}
			}
		}
		
		outerLoop:
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(i==j)continue;
				
			}
		}
		
	}

}
