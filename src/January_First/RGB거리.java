package January_First;

import java.io.*;
import java.util.*;


public class RGB거리 {
	
	static class Node implements Comparable<Node>{
		
		int to;
		int weight;
		
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			
			return weight - o.weight;
		}
			
	}
	
	static int N,V,dist[];
	static List<List<Node>> list;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		V = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		list = new ArrayList<>();
		for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
		
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, weight));
		}
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		Arrays.fill(dist, 987654321);
		bfs(start);
		
		System.out.println(dist[end]);
		
	}
	
	static void bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		boolean[]visited = new boolean[N+1];
		pq.offer(new Node(start,0));
		
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node nowNode = pq.poll();
			
			if(visited[nowNode.to]) continue;
			
			visited[nowNode.to] = true;
			
			for(Node nextNode : list.get(nowNode.to)) {
				
				if(!visited[nextNode.to] && dist[nextNode.to] > dist[nowNode.to] + nextNode.weight) {
					dist[nextNode.to] = dist[nowNode.to] + nextNode.weight;
					pq.offer(new Node(nextNode.to, dist[nextNode.to]));
				}
				
			}
			
			
		}
		
		
	}
	
	
	
	
}	