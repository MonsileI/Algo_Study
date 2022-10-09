package Dijikstra;

import java.io.*;
import java.util.*;


public class dijikstraListTest {
	
	static class Node implements Comparable<Node>{
		
		int idx,weight;

		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			
			return weight - o.weight;
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[]dist = new int[N];
		
		List<ArrayList<Node>> graph = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));

		}
		
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int start = 0;
		
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			
			int idx = node.idx;
			int weight = node.weight;
			
			if(dist[idx] < weight) continue;
			
			for(int i=0;i<graph.get(idx).size();i++) {
				int cost = dist[idx] + graph.get(idx).get(i).weight;
				
				if(dist[graph.get(idx).get(i).idx] > cost) {
					dist[graph.get(idx).get(i).idx] = cost;
					pq.offer(new Node(graph.get(idx).get(i).idx, cost));
				}
			}
			
			
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(dist[N-1]);
		
	}
}
