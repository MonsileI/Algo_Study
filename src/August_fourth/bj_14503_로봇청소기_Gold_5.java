package August_fourth;

import java.io.*;
import java.util.*;

public class bj_14503_로봇청소기_Gold_5 {

	static int N;
	static int M;
	static int[][]map;
	static int ri, rj, rd;
	static int answer;
	static int [][]face = {{-1,0},{0,-1},{0,1},{0,1}}; //반시계

	
	/*
	 1. 현재 위치 청소
	 
	 2. 현재 위치에서 현재 방향 기준 왼쪽 방향부터 차례대로 탐색
	 	1) 왼쪽 방향에 아직 청소를 안했다면, 그 방향으로 회전한 다음 한 칸 전진, 1번(청소)으로 돌아감
	 	2) 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전한 다음 2번으로 돌아감
	 	3) 네 방향 모두 청소가 이미 되어있거나 벽인 경우, 바라보는 방향 유지한 채로 후진하고 2번
	 	4) 네 방향 모두 청소가 이미 되어있거나 벽, 후진도 못할 경우 작동 멈춤
	 
	 * */
	
	static int cnt = 0;
	
	static void calc() {
		
		while(true) {
			
			//1단계
			if(map[ri][rj]==0) {
				answer++;
				map[ri][rj]= 8;
			}
			
			//2단계
			rd = (rd+1) %4;
			int ni = ri + face[rd][0];
			int nj = rj + face[rd][1];
			
			if(map[ni][nj]==0) {
				map[ni][nj]=8;
				answer++;
				ri = ni;
				rj = nj;
			}else {
				
			}
			
			
			
		}
		
		
		
		
		//System.out.println(answer);
		
		
	}
	
	static void input() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," "); 
		ri = Integer.parseInt(st.nextToken());
		rj = Integer.parseInt(st.nextToken());
		rd = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," "); 
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		input();
		
		calc();
		
		
	}
}
