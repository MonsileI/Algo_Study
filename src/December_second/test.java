package December_second;

import java.util.*;
import java.io.*;

public class test {

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
			int num = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			visited[num] = true;
			int ans = 0 ;
			q.offer(num);
			while(!q.isEmpty()) {
				
				int c = q.poll();
				
				for(int [] a : adj[c]) {
					if(!visited[a[0]] && a[1] >= dist) {
						visited[a[0]] = true;
						q.offer(a[0]);
						ans++;
					}
				}
				
			}
			
			sb.append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
