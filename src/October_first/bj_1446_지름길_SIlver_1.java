package October_first;

import java.util.*;
import java.io.*;

public class bj_1446_지름길_SIlver_1 {
	

	static class Node  implements Comparable<Node>{
		
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			
			if(from == o.from) return to - o.to;
			return from - o.from;
		}
		

	
	}
	
	
	public static void main(String[] args) throws Exception{
		
		//전체 최단거리를 dijikstra로 구한 뒤, 가장 가까운 값 뽑아서 + 해줘볼까? ㅠ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		
		int[] dist = new int[10001];
		List<Node> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			//역주행 x
			if(to > D) continue;
			//지름길로 가는것보다 그냥 가는게 빠르면, 걸러줌
			if(to- from <= weight) continue;
			
			list.add(new Node(from,to,weight));
			
		}
		
		Collections.sort(list);
	
		Arrays.fill(dist, 10001);
		dist[0] = 0;

		int idx =0; 
		int range =0;
		while(range < D) {
			
			if(idx< list.size()) {
				Node node = list.get(idx);
				if(node.from == range) {
					dist[node.to] = Math.min(dist[range]+ node.weight, dist[node.to]);
					idx++;
				}else {
					dist[range+1] = Math.min(dist[range+1], dist[range]+1);
					range++;
				}
			}else {
				dist[range+1] = Math.min(dist[range+1], dist[range]+1);
				range++;
			}

		}
		
		System.out.println(dist[D]);
		
		
	}
}
