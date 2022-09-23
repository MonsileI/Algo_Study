package September_third;

import java.util.*;

public class Soluiont_pr_메뉴리뉴얼 {
	
	static List<String> answerList = new ArrayList<>();
	static Map<String,Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int [] course = {2,3,4};
		
		//두 메뉴 이상 2번 이상
		
		//AB AC AF AG
		
		//일단 정렬
		
		int idx = 0;
		for(String str : orders) {
			
			char[]tmp = str.toCharArray();
			Arrays.sort(tmp);
		
			orders[idx++] = String.valueOf(tmp);
			
		}
		
		
		for(int c : course) {
			for(String order : orders) {
				dfs(c,order,"",0);
			}
			
			List<Integer> tmpList = new ArrayList<>(map.values());
			Collections.sort(tmpList);
			int maxNum = tmpList.get(tmpList.size()-1);
			if(maxNum<=1) continue;
			for(String key : map.keySet()) {
				if(map.get(key)==maxNum) answerList.add(key);
			}
			
			map.clear();
		}
		
		Collections.sort(answerList);
		System.out.println(answerList);
	}
	
	static void dfs(int count,String order,String now,int start) {
		
		if(count==0) {
			if(!map.containsKey(now)) {
				map.put(now, 0);
			}
			map.put(now, map.get(now)+1);
			return;
		}
		
		for(int i=start;i<order.length();i++) {	
			dfs(count-1,order,now+order.charAt(i),i+1);
		}
		
		
	}

}
