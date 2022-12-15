package December_second;

import java.util.*;
import java.io.*;

public class test {

	static class Node implements Comparable<Node>{
		
		int idx,dist;

		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if(this.dist < o.dist) return -1;
			return 1;
		}
		
		
		
		
	}
	
	static ArrayList<ArrayList<Node>> list;
	static int[]d = new int[50001];
	static int n,m;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i=0;i<=n;i++) list.add(new ArrayList<>());
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c =  Integer.parseInt(st.nextToken());
				
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
		}
		
		Arrays.fill(d, 987654321);
		
		dijkstra();
		
		System.out.println(d[n]);
	}
	
	static void dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(1,0));
		d[1] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.dist;
			int now = node.idx;
			
			if(d[now]< dist) continue;
			
			for(int i=0;i<list.get(now).size();i++) {
				int cost = d[now] + list.get(now).get(i).dist;
				if(cost < d[list.get(now).get(i).idx]) {
					d[list.get(now).get(i).idx] = cost;
					pq.offer(new Node(list.get(now).get(i).idx, cost));
				}
			}
		}
		
		
	}
}
