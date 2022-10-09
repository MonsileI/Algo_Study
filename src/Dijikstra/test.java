package Dijikstra;

import java.util.*;

import Dijikstra.dijikstraListTest.Node;

import java.io.*;
/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0
 * */

/*
10 17
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4
 * */
public class test {
	
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
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Node>> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) list.add(new ArrayList<Node>());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to,weight));	
		}
		
		int start = 0;
		int end = N-1;
		int []dist = new int [N];
		
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			
			int idx = node.to;
			int weight = node.weight;
			
			if(dist[idx] < weight) continue; //이미 도달할 크기가 앞으로 저기로 가는 크기보다 작을 경우 continue;
			

			
			for(int i=0;i<list.get(idx).size();i++) {
				
				int cost = dist[idx] + list.get(idx).get(i).weight;
				
				if(dist[list.get(idx).get(i).to] > cost) {
					dist[list.get(idx).get(i).to] = cost;
					pq.offer(new Node(list.get(idx).get(i).to,cost));
				}
			}
			
			
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(dist[end]);
	}

}
