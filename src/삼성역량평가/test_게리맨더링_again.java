package 삼성역량평가;

import java.util.*;
import java.io.*;

public class test_게리맨더링_again {

	static int N, pop[];
	static boolean adj[][], tmp[];
	static int answer = 987654321;
	static int total;
	

	static boolean check(List<Integer>list) {
		
		int size = list.size();
		int cnt = 0;
		boolean [] visited = new boolean[size];
		
		visited[0] = true;
		
		Queue<Integer>q = new ArrayDeque<Integer>();
		
		q.offer(0);
		
		while(!q.isEmpty()) {
			
			cnt++;
			
			int idx = q.poll();
			int num = list.get(idx);
			
			if(cnt==size) return true;
			
			
			for(int i=0;i<size;i++) {
				if(i==idx)continue;
				int tmpNum = list.get(i);
				
				if(!visited[i] && adj[num][tmpNum]) {
					visited[i] = true;
					q.offer(i);
				}
				
			}
		}
		
		return false;
		
		
	}
	
	static void calc() {
		
		List<Integer> fir = new ArrayList<>();
		List<Integer> sec = new ArrayList<>();
		int a=0, b=0;
		
		
		for(int i=1;i<N+1;i++) {
			if(tmp[i]) {
				fir.add(i);
				a+= pop[i];
			}
			else {
				sec.add(i);
				b+= pop[i];
			}
		}
		
		if(fir.isEmpty()||sec.isEmpty()) return;
		
		if(!check(fir)) return;
		if(!check(sec)) return;
		
		
		
		
		answer = Math.min(answer, Math.abs(a-b));
		
	}
	
	
	static void sub(int depth) {
		
		
		if(depth==N+1) {
		
			calc();
			
			return;
		}
		
		tmp[depth] = true;
		sub(depth+1);
		tmp[depth] = false;
		sub(depth+1);
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adj = new boolean[N+1][N+1];
		tmp = new boolean[N+1];
		pop = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		for(int i=1;i<N+1;i++) {
			int num = Integer.parseInt(st.nextToken());
			pop[i] = num;
			total += num;
		}
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int size = Integer.parseInt(st.nextToken());
			for(int j=0;j<size;j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[i][to] = true;
			}
		}
		
		
		sub(1);
		
		System.out.println(answer == 987654321 ? -1 : answer);
		
	}
}
