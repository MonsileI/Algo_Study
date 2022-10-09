import java.io.*;
import java.util.*;

public class test {

	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][]info = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dist = new int[N];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		int start = 0;
		int end = N-1;
		dist[start] = 0;
		
		int idx, min;
		boolean[]visited = new boolean[N];
		for(int i=0;i<N;i++) {
			
			idx = -1;
			min = INF;
			
			for(int j=0;j<N;j++) {
				
				if(!visited[j] && min > dist[j]) {
					idx =j;
					min = dist[j];
				}
				
			}
			
			if(idx==-1) break;
			if(visited[end]) break;
			
			visited[idx] = true;
			
			for(int j=0;j<N;j++) {
				
				if(!visited[j] && info[idx][j] !=0 && dist[j] > info[idx][j] + dist[idx]) {
					dist[j] = info[idx][j] + dist[idx];
				}
				
			}
					
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(dist[end]);
		
	}
}
