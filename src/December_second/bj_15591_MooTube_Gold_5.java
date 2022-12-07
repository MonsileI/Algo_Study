package December_second;

import java.util.*;
import java.io.*;

public class bj_15591_MooTube_Gold_5 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
	
		
		List<int[]>[] adj = new ArrayList[N+1];
		
		for(int i=0;i<N+1;i++) adj[i] = new ArrayList<>();
		
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj[from].add(new int[] {to,weight});
			adj[to].add(new int[] {from,weight});
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dist = Integer.parseInt(st.nextToken());
			int checkNum = Integer.parseInt(st.nextToken());
			boolean[]visited = new boolean[N+1];
			visited[checkNum] = true;
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(checkNum);
			
			int ans =  0;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int[] a : adj[cur]) {
					if(!visited[a[0]] && a[1] >= dist) {
						q.offer(a[0]);
						visited[a[0]] = true;
						ans++;
					}
				}
				
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
