package January_First;

import java.util.*;
import java.io.*;

public class bj_1753_최단경로_Gold_4 {

	static class Node implements Comparable<Node>{
		int to,weight;

		
		
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
	
	static int V,E,dist[];
	static List<ArrayList<Node>> list;
	
	static void dik(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start,0));
		boolean[]visited = new boolean[V+1];
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node nowNode = pq.poll();
			
			if(visited[nowNode.to]) continue;
			
			visited[nowNode.to] = true;
			
			for(Node nextNode : list.get(nowNode.to)) {
				
				if(!visited[nextNode.to] && dist[nextNode.to] > dist[nowNode.to] + nextNode.weight) {
						dist[nextNode.to] = dist[nowNode.to] + nextNode.weight;
						pq.offer(new Node(nextNode.to,dist[nextNode.to]));
				}
				
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V+1];
		int inf = 987654321;
		Arrays.fill(dist, inf);
		
		int start = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0;i<V+1;i++) list.add(new ArrayList<Node>());
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(t,w));
			
		}
		
		dik(start);
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<V+1;i++) {
			
			if(dist[i]==inf) sb.append("INF");
			else sb.append(dist[i]);
			
			if(i==V)break;
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
