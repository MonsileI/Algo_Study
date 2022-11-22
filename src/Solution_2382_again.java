

import java.util.*;
import java.io.*;

public class Solution_2382_again {

	static class Microbe implements Comparable<Microbe>{
			
			int i,j,cnt,dir,live;
			
			public Microbe(int i, int j, int cnt, int dir, int live) {
				super();
				this.i = i;
				this.j = j;
				this.cnt = cnt;
				this.dir = dir;
				this.live = live;
			}

			@Override
			public int compareTo(Microbe o) {
				return -(cnt-o.cnt);
			}
	}
	
	static int N,M,K;
	static Microbe[]arr;
	static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	
	static void calc() {
		
		//이동
		
		for(int c=0;c<K;c++) {
			
			if(arr[c].live==-1) continue;
			
			int ni = arr[c].i + move[arr[c].dir][0];
			int nj = arr[c].j + move[arr[c].dir][1];
			int size = arr[c].cnt;
			int dir = arr[c].dir;
			
			if(ni==0||nj==0||ni==N-1||nj==N-1) {
				dir = (dir+2)%4;
				size /= 2;
			}
			
			if(size==0) {
				arr[c].live = -1;
				continue;
			}
			
			arr[c].i = ni;
			arr[c].j = nj;
			arr[c].cnt = size;
			arr[c].dir = dir;
			
			
			
		}
		Arrays.sort(arr);
		for(int f=0;f<K;f++) {
			
			if(arr[f].live==-1) continue;
			int fi = arr[f].i;
			int fj = arr[f].j;
			
			for(int s=0;s<K;s++) {
				if(f==s)continue;
				if(arr[s].live==-1) continue;
				int si = arr[s].i;
				int sj = arr[s].j;
				
				if((fi==si)&&(fj==sj)) {
					arr[f].cnt += arr[s].cnt;
					arr[s].live = -1;
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=TC;t++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new Microbe[K];
			
			for(int d=0;d<K;d++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());	
				//상하좌우 1234
				//상우하좌 0123
				if(dir==1) dir=0;
				else if(dir==4) dir=1;
				
				arr[d] = new Microbe(i,j,cnt,dir,0);
			}
			
			while(true) {
				
				M--;
				
				calc();
				
				if(M==0) break;
				
			}
			int answer = 0;
			
			for(int i=0;i<K;i++) {
				if(arr[i].live==-1) continue;
				answer += arr[i].cnt;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
