package October_third;

import java.util.*;
import java.io.*;


public class bh_20006_랭킹전대기열_Silver_2 {
	
	static class User implements Comparable<User>{
		int level;
		String id;
		public User(int level, String id) {
			super();
			this.level = level;
			this.id = id;
		}
		@Override
		public int compareTo(User o) {
			return id.compareTo(o.id);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//처음 기준 -10 ~ +10
		
		//입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기
			//1. 먼저 생성된 방에 입장
		
		//정원이 모두 차면 게임을 시작
		
		
		//p 플레이어 수 , n 플레이어 닉네임, l 플레이어 레벨, m 방 한개의 정원
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		TreeMap<Integer, List<User>> map = new TreeMap<>();
		int idx= 0;
		boolean flag;
		for(int i=0;i<p;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			
			String id = st.nextToken();
			
			if(map.isEmpty()) {
				map.put(idx, new ArrayList<User>());
				map.get(idx).add(new User(l,id));
				idx++;
			}else {

				int num = 0;
				flag = false;
				for(Integer key : map.keySet()) {
					
					int limit = map.get(key).get(0).level;
					if(Math.abs(limit-l)<=10) {
						
						map.get(key).add(new User(l,id));
						
						if(map.get(key).size()==m) {
							
							Collections.sort(map.get(key));
							
							for(int j=0;j<m;j++) {
								sb.append(map.get(key).get(j).level+" "+map.get(key).get(j).id+"\n");
							}
						
							num = key;	
							flag = true;
						}
						break;
					}
					
				}
				
				if(flag)map.remove(num);
			}
			
			
		}
		System.out.println(map.get(1).get(0).id);
		System.out.println("==============");
		System.out.println(sb.toString());
	}
}
