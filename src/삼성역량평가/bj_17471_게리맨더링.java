package 삼성역량평가;

import java.io.*;
import java.util.*;

public class bj_17471_게리맨더링 {
	
	static int N;
	static boolean [][]link;
	static int [] arr;
	static boolean[] first;
	static boolean[] second;
	static int answer = 987554321;
	static List<Integer> fList;
	static List<Integer> sList;
	static int total;
	/*
	 첫번째 정보는 인접한 수,
	 두번째 공백부터는 인접한 구역의 번호
	같은 선거구가 되려면, 서로 인접하면 됨!
	
	인구 차이를 최소로 두 선거구를 나누면 됨!
	 * */
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		
		link = new boolean[N+1][N+1];
		first = new boolean[N+1];
		second = new boolean[N+1];
	
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int size = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<size;j++) {
				int li = Integer.parseInt(st.nextToken());
				link[i][li] = true;
			}
			
		}
	
		
		sub(1);
		
		System.out.println(answer==987554321 ? -1 : answer );
		
	}

	//두개의 조합으로 나누려면?
	
	static void calc() {
		
		
		Queue<Integer> fq = new ArrayDeque<>();
		
		int size = fList.size();
		
		fq.offer(0); //리스트의 인덱스
		
		boolean[] fv = new boolean[size];
		boolean flag = false;

		fv[0] = true;
		int cnt = 0;
		int a = 0;
		
		while(!fq.isEmpty()) {
			
			
			cnt++;
			
			int idx = fq.poll();
			
			
			int num = fList.get(idx);
		
			if(cnt==size) {
				flag = true;
				break;
			}
			
			for(int i=0;i<size;i++) {
				if(i==idx) continue;
				int tmpNum = fList.get(i);
				if(!fv[i] && link[num][tmpNum]) {
					fv[i] = true;
					fq.offer(i);
				}
				
			}
			
		}

		
		if(!flag) return;
		
		
		Queue<Integer> sq = new ArrayDeque<>();
		
		size = sList.size();
		
		sq.offer(0); //리스트의 인덱스
		
		
		boolean[] sv = new boolean[size];
		flag = false;

		sv[0] = true;
	
		cnt = 0;
		
		while(!sq.isEmpty()) {
			
			cnt++;
			
			int idx = sq.poll();

			int num = sList.get(idx);
		
			
			if(cnt==size) {
				flag = true;
				break;
			}
			
			for(int i=0;i<size;i++) {
				if(i==idx) continue;
				int tmpNum = sList.get(i);
			
				if(!sv[i] && link[num][tmpNum]) {
					sv[i] = true;
					sq.offer(i);
				}
				
			}
			
		}
		
		if(!flag) return;
		
		
		a = 0;
		for(int i=0;i<fList.size();i++) a += arr[fList.get(i)];
		int b = 0;
		for(int i=0;i<sList.size();i++) b += arr[sList.get(i)];
		
	
		
		answer = Math.min(answer, Math.abs(a-b));
		
	
		
	}
	
	static void sub(int depth) {
		
		if(depth==N+1) {
			
			fList = new ArrayList<>();
			sList = new ArrayList<>();
			
			
			for(int i=1;i<N+1;i++) if(first[i]) fList.add(i);	
			for(int i=1;i<N+1;i++) if(second[i]) sList.add(i);	
			
			if(fList.isEmpty() || sList.isEmpty()) return;
			
			calc();
			
			return;
		}
		
		
		
		first[depth] = true;
		sub(depth+1);
		first[depth] = false;
		second[depth] = true;
		sub(depth+1);
		second[depth] = false;
	}
	
	
}
