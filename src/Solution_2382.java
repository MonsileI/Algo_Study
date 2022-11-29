
import java.util.*;
import java.io.*;

public class Solution_2382 {
	
	static class Microbe implements Comparable<Microbe>{
		int i,j,s,d,l;
		@Override
		public int compareTo(Microbe o) {
			return -(s-o.s);
		}
		
		public Microbe(int i, int j, int s, int d,int l) {
			super();
			this.i = i;
			this.j = j;
			this.s = s;
			this.d = d;
			this.l = l;
		}
		
	}
	
	
	static int N,M,K;
	static Microbe[] mArr;
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	
	
	static void calc() {
		
		//이동
		
		for(int c=0;c<K;c++) {
			Microbe m = mArr[c];

			if(m.l==-1) continue;
			int i = m.i;
			int j = m.j;
			int cnt = m.s;
			int dir = m.d;
			
			i += move[dir][0];
			j += move[dir][1];
			
			if(i==0 || j==0 || i==N-1 || j==N-1) {
				cnt /= 2;
				dir = (dir+2)%4;
				
			}
			mArr[c].i = i;
			mArr[c].j = j;
			mArr[c].s = cnt;
			mArr[c].d = dir;
		
		}
		
		Arrays.sort(mArr);
		//냠냠
		
		for(int c=0;c<K;c++) {
			
			Microbe nm = mArr[c];
			if(nm.l==-1) continue;
			for(int cc=0;cc<K;cc++) {
				
				if(c==cc) continue;
				Microbe tm = mArr[cc];
				if(tm.l==-1) continue;
				
				if((nm.i==tm.i) && (nm.j==tm.j)) {
					mArr[c].s += tm.s;
					mArr[cc].l = -1;
				}
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int t=1;t<=TC;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken()); //좌표크기
			M = Integer.parseInt(st.nextToken()); //초 수
			K = Integer.parseInt(st.nextToken()); //군집 개수
			
			mArr = new Microbe[K];

			for(int c=0;c<K;c++) {
				st = new StringTokenizer(br.readLine()," ");
				
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if(d==1) d=0;
				else if(d==4) d=1;
				//1234 상하좌우
				//0123 상우하좌
				mArr[c] = new Microbe(i,j,s,d,0);
			}
			
			while(true) {
				
				M--;
				
				calc();
					
				if(M==0) break;
			}
			
			int answer = 0;
			
			for(int i=0;i<K;i++) {
				Microbe m = mArr[i];
				if(m.l==-1) continue;
				answer += m.s;
			}
			
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
