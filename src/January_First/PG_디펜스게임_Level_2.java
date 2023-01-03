package January_First;

import java.util.*;

public class PG_디펜스게임_Level_2 {
	
	public static void main(String[] args) {
		
		int n = 7;
		int k = 3;
		int []enemy = {4,2,4,5,3,3,1};
		int answer = -1;
	
		int size = enemy.length;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<size;i++) {
			
			pq.offer(enemy[i]);
			
			if(k<pq.size()) n -= pq.poll();
			
			if(n<0) {
				answer = i;
				break;
			}
		}
		
		if(answer==-1) answer = size;
		
		
		System.out.println(answer);
	}

}

