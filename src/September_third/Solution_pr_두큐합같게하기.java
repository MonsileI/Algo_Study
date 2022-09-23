package September_third;

import java.util.*;

public class Solution_pr_두큐합같게하기 {

	public static void main(String[] args) {
		int answer = 0;
		int []queue1 = {3,2,7,2};
		int []queue2 = {4,6,5,1};
		
		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();
		int sum = 0;
		int na = 0, nb =0;
		for(int i=0;i<queue1.length;i++) {
			sum += queue1[i];
			na += queue1[i];
			q1.offer(queue1[i]);
			sum += queue2[i];
			nb += queue2[i];
			q2.offer(queue2[i]);
		}
		
		if(sum%2==1) {
			System.out.println(-1);
			return;
		}
		
		
		int a =0,b=0;
		int len = queue1.length;

		
		while(a<= len*2 || b<= len*2) {
		
			
			if(na==nb) {
				answer = a+b;
				break;
			}else if(na<nb) {
				na += q2.peek();
				nb -= q2.peek();
				a++;
				q1.offer(q2.poll());
				
			}else {
				na -= q1.peek();
				nb += q1.peek();
				b++;
				q2.offer(q1.poll());
				
			}
			
			
		}
		


		System.out.println(answer);
		
		
	}
}
