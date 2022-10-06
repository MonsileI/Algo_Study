package 삼성역량평가;

import java.util.*;
import java.io.*;


public class bj_17143_낚시왕_Gold_1 {
	
	
	static class Shark implements Comparable<Shark>{
		
		int i,j,speed,dir,size,live;

		public Shark(int i, int j, int speed, int dir, int size, int live) {
			super();
			this.i = i;
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.live = live;
		
		}

		@Override
		public int compareTo(Shark o) {
			
			return i - o.i;
		}

		@Override
		public String toString() {
			return "Shark [i=" + i + ", j=" + j + ", speed=" + speed + ", dir=" + dir + ", size=" + size + ", live="
					+ live + "]";
		}
		
		
	}
	
	
	static void output() {
		System.out.println(answer);
	}
	
	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		shark = new Shark[S];
	
		for(int t=0;t<S;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			shark[t] = new Shark(i,j,s,d,z,0);
		}
		
	}
	
	static void fish() {
		
		//낚시왕
		
		for(int i=0;i<S;i++) {
			Shark s = shark[i];
			if(s.j==loc) {
				shark[i].live=-1;
				answer += shark[i].size;
				break;
			}
			
		}
	
	
	}
	
	//1 위 2 아래 3 오른 4 왼
	static void moveShark() {
		
		for(int d=0;d<S;d++) {
			Shark s = shark[d];
			if(s.live==-1) continue;
			
			int iSize = (N-1)*2;
			int jSize = (M-1)*2;
			int i = s.i;
			int j = s.j;
			int dir = s.dir;
			int speed = s.speed;
			int idx = 0; //여기지롱
			
			
			if(dir==1) { //위
				if(((speed-i) / iSize)  % 2 ==1) shark[d].dir = 1;
				speed = speed % iSize;
				shark[d].i = i - speed;
			}else if(dir==2) { //아래
				if(((i+speed) / iSize)  % 2 ==1) shark[d].dir = 1;
				speed = speed % iSize;
				shark[d].i = i + speed;
			}else if(dir==3) { //왼
				if(((speed-j) / jSize)  % 2 ==1) shark[d].dir = 4;
				speed = speed % jSize;
				shark[d].j = j - speed;
			}else { //오
				if(((speed-j) / jSize)  % 2 ==1) shark[d].dir = 3;
				speed = speed % jSize;
				shark[d].j = j + speed;
			}
			
			
		}
		
	
		
	}
	
	static void sharkEat() {
		//크기별로 정렬
		Arrays.sort(shark);
		
		for(Shark s : shark) System.out.println(s);
		
		int[][]map = new int[N][M];
		
		for(int i=0;i<S;i++) {
			
			Shark s = shark[i];
			
			if(map[s.i][s.j]!=0) {
				shark[i].live=-1;
			}else map[s.i][s.j] = s.size;	
			
			
		}
		
	}
	
	
	static void calc() {
		
		while(true) {
			loc++;
			//낚시왕
			fish();
			
			//상어 움직임
			moveShark();
		
			//상어 먹음
			sharkEat();
		
			if(loc==M-1) break;
		}
		
	}
	
	static  int N,M,S;
	static Shark[] shark;
	static int answer;
	static int loc = -1;
	
	public static void main(String[] args) throws Exception{
		
		input();
		calc();
		output();
	}

}
