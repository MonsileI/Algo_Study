package January_First;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PG_귤고르기_Level_2 {
	
	public static void main(String[] args) {
		
		int k = 2;
		
		int [] tangerine = {1,1,1,1,2,2,2,3};
		
		int answer = 1;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<tangerine.length;i++) {
			int num = tangerine[i];
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
		
		for(Integer num : map.keySet()) pq.offer(map.get(num));
		
		while(true) {
			k -= pq.poll();
			if(k<=0) break;
			answer++;
		}
		
		System.out.println(answer);
		
	}

}
