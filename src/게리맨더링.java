import java.util.*;
import java.io.*;


public class 게리맨더링 {

	static int  total,N, pop[];
	static boolean tmp[], adj[][];
	static int answer = Integer.MAX_VALUE;
	
	
	static boolean check(List<Integer>list) {
		int size = list.size();
		boolean[]visited = new boolean[size];
		visited[0] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt++;
			
			int idx = q.poll();
			int num = list.get(idx);
			
			for(int i=0;i<size;i++) {
				if(idx==i) continue;
				if(visited[i]) continue;
				int tmpNum = list.get(i);
				if(!adj[num][tmpNum]) continue;
				
				visited[i] = true;
				q.offer(i);
			}
			
			
		}
		
		
		if(cnt==size) return true;
		else return false;
		
	}
	
	
	
	static void calc() {
		
		List<Integer> fir = new ArrayList<>();
		List<Integer> sec = new ArrayList<>();
		
		
		int a = 0; //fir 인구
		
		for(int i=0;i<N;i++) {
			if(tmp[i]) {
				fir.add(i);
				a += pop[i];
			}else sec.add(i);
		}
		
		
		if(fir.isEmpty() || sec.isEmpty()) return;
		
		
		if(!check(fir) || !check(sec)) return;
		
		
		
		int b = total - a;

		answer = Math.min(answer, Math.abs(a-b));
		
	}
	
	
	
	static void sub(int depth) {
		
		
		if(depth==N) {
			calc();
			return;
		}
		
		
		
		
		
		tmp[depth] = true;
		sub(depth+1);
		tmp[depth] = false;
		sub(depth+1);
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		pop = new int[N];
		adj = new boolean[N][N];
		tmp = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		for(int i=0;i<N;i++) {
			total += pop[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int size = Integer.parseInt(st.nextToken());
			for(int j=0;j<size;j++) {
				int to = Integer.parseInt(st.nextToken())-1;
				adj[i][to] = true;
			}
		}
		
		sub(0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}
