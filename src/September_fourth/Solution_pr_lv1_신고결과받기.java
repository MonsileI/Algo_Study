package September_fourth;

import java.util.*;

class Solution_신고결과받기 {
	
	static Map<String,Set<String>> giveMap = new HashMap<>(); //내가 신고를 '한' 맵
	static Map<String,Integer> takeMap = new HashMap<>(); //내가 신고를 '당한' 맵
	static Map<String,Integer> answerMap = new HashMap<>();
	
	
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        for(int i=0;i<id_list.length;i++) {
        	String str = id_list[i];
        	giveMap.put(str, new HashSet<>());
        	takeMap.put(str, 0);
        	answerMap.put(str, 0);
        	
        }
        
        for(String rep : report) {
        	
        	String[]tmp = rep.split(" ");
        	
        	String attaker = tmp[0];
        	String taker = tmp[1];
        	
        	if(giveMap.get(attaker).contains(taker)) continue;
        	
        	giveMap.get(attaker).add(taker);
        	
        	takeMap.put(taker, takeMap.getOrDefault(taker, 0)+1);
        	
        }
 
      
        List<String> deathNote = new ArrayList<>();
        
        for(String key : takeMap.keySet()) {
        	
        	if(takeMap.get(key)<k) continue;
        	deathNote.add(key);
        }
        
        
        for(String key : giveMap.keySet()) {
        		for(String death : deathNote) {
        			if(giveMap.get(key).contains(death)) {
        				answerMap.put(key, answerMap.getOrDefault(key, 0)+1);
        			}
        	}
        }
        
        answer = new int[id_list.length];
        for(int i =0 ;i<id_list.length;i++) {
        	String str = id_list[i];
        	answer[i] = answerMap.get(str);
        }
        
    
        return answer;
    }
}
public class Solution_pr_lv1_신고결과받기 {

	public static void main(String[] args) {
		
	
		Solution_신고결과받기 sol = new Solution_신고결과받기();
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		int[]s = sol.solution(id_list	, report, k);
		
		for(int i : s)System.out.print(i+" ,");
	
	}

}
