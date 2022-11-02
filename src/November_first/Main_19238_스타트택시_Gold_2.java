package November_first;

import java.util.*;
import java.io.*;

public class Main_19238_스타트택시_Gold_2 {
	
	static class Client {
		
		int si,sj,gi,gj;

		public Client(int si, int sj, int gi, int gj) {
			super();
			this.si = si;
			this.sj = sj;
			this.gi = gi;
			this.gj = gj;
		}
	
	}
	
	static int N,C,ti,tj,F,map[][];
	static ArrayList<Client> cArr;
	static int index;
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean flag;
	
	static void calc(int sum) {
		
		
		
		if(F-sum<0) {
			System.out.println(F);
			
			flag = false;
			return;
		}else {
			
			int dist = 0;
			F -= sum;
			
			Queue<int[]> q= new ArrayDeque<>();
			
			q.offer(new int[] {cArr.get(index).si,cArr.get(index).sj,0});
			boolean[][]visited = new boolean[N][N];
			
			while(!q.isEmpty()) {
				int []c = q.poll();
				int i = c[0]; 
				int j = c[1];
				int cnt = c[2];
				
				if(i==cArr.get(index).gi && j==cArr.get(index).gj) {
					dist = cnt;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int ni = i + move[d][0];
					int nj = j + move[d][1];
					
					if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
					
					if(!visited[ni][nj] && map[ni][nj]==0) {
						visited[ni][nj] = true;
						q.offer(new int[] {ni,nj,cnt+1});
					}	
				}
			}
			if(dist==0) {
				flag=false;
				return;
			}else if(F - dist <0) {
				flag=false;
				return;
			}else {
				F -= dist;
				F += dist*2;
				ti = cArr.get(index).gi;
				tj = cArr.get(index).gj;
				cArr.remove(index);
			}
			
			
		}
		
	}
	
	static void bfs() {
		
		int minDis = 987654321;
		int size = cArr.size();
		
		for(int f=0;f<size;f++) {
			
			int sum = 0;
			
			boolean[][]visited = new boolean[N][N];
			Queue<int[]> q = new ArrayDeque<>();
			
			q.offer(new int[] {ti,tj,0});
			
			while(!q.isEmpty()) {
				
				int [] c = q.poll();
				
				int i = c[0];
				int j = c[1];
				int cnt = c[2];
				
				if(i==cArr.get(f).si && j==cArr.get(f).sj) {
					sum = cnt;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int ni = i + move[d][0];
					int nj = j + move[d][1];
					
					if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
					
					if(!visited[ni][nj] && map[ni][nj]==0) {
						visited[ni][nj] = true;
						q.offer(new int[] {ni,nj,cnt+1});
					}	
				}
			}
			
			if(sum<minDis) {
				index = f;
				minDis = sum;
			}else if(sum==minDis){
				if(cArr.get(f).si < cArr.get(index).si) {
					index = f;
				}else if(cArr.get(f).si == cArr.get(index).si) {
					if(cArr.get(f).sj < cArr.get(index).si) {
						index = f;
					}
				}
			}
		}
		if(minDis==987654321) {
			flag = false;
			return;
		}
		calc(minDis);
		
	}
		
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		cArr = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		
		ti = Integer.parseInt(st.nextToken())-1;
		tj = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int f = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken())-1;
			int fo = Integer.parseInt(st.nextToken())-1;
			cArr.add(new Client(f,s,t,fo));
		}
		while(true) {
			
			flag = true;
			bfs();
			
			if(!flag) {
				F = -1;
				break;
			}
			
			if(cArr.size()==0) break;
		}
		
		
		System.out.println(cArr.size()!=0 ? -1 : F);
	}

}
