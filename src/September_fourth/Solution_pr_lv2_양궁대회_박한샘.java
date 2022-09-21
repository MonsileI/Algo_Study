package September_fourth;

import java.util.*;

public class Solution_pr_lv2_양궁대회_박한샘 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		int n = 5;
		int [] info = {2,1,1,1,0,0,0,0,0,0,0};
		System.out.println(s.solution(n, info));
	}
	
	
	static class Solution{
		
		static int [] apeach;
		static int [] ryan;
		static boolean[] visited;
		static int count;
		static List<int[]> answerList = new ArrayList<>();
		static int maxDiff = Integer.MIN_VALUE;
		
		public int[] solution(int n, int[] info) {
	        
			int[] answer = {};
	        count = n;
			apeach = info.clone();
			ryan = new int[11];
	        
			//len = 11, 11개 화살 -> 0부터 10까지
			dfs(0,0);
	        
			for(int [] i : answerList)System.out.println(Arrays.toString(i));
	        return answer;
	        
	    	}
		
		static void dfs(int start, int depth) {
	
			if(depth==count) {
				
				int r =0;
				int a =0;
				for(int i=0;i<11;i++) {
					if(ryan[i]==0 && apeach[i]==0) continue;
					if(ryan[i]>apeach[i]) r += 10-i;
					else a += 10-i;
				}
				if(r>a) {
					int diff= r-a ;
					if(diff>maxDiff) {
						maxDiff = diff;
						answerList.clear();
						answerList.add(ryan.clone());
					}else if(diff==maxDiff) answerList.add(ryan.clone());
					
				}
				return;
			}
			
		
			for(int i=start;i<11;i++) {
				ryan[i]++;
				dfs(start+1,depth+1);
				ryan[i]--;
			}
		
		}
		
		
	}

}

