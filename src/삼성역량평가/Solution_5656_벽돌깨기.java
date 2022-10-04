package 삼성역량평가;

import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기 {
	
	static int [][]map;
	static int CNT;
	static int N,M;
	static int [] permArr;
	static int answer;
	
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//순열 후 터뜨려야겠다.
		
		int tc = Integer.parseInt(br.readLine());
		
		answer = Integer.MIN_VALUE;
		
		for(int t=1;t<=tc;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			CNT = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
				
			
			map = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		//순열 만들기
		permArr = new int[CNT];

		perm(0);	
			
		
		}
		
	}
	
	
	static void calc(int idx) {
		
		//떨어뜨리고
		int[][]tmp = new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				tmp[i][j] = map[i][j];
		boolean flag = false;
		
		int range = 0; //초기 폭발 규모 
		int h = 0;     //초기 폭발 위치
		
		for(int i=0;i<N;i++) {
			if(tmp[i][idx]!=0) {
				flag = true;
				range = tmp[i][idx];
				h = i;
				break;
			}
		}
		
		//아무일도 없었으면 연쇄폭발도 없다~ 이마리야
		if(!flag) return;
		
		//연쇄폭팔 ㅠ
		Queue<int[]> bombs = new ArrayDeque<>();
		bombs.offer(new int[] {h,idx,range});
		while(!bombs.isEmpty()) {
			int[]c = bombs.poll();
			
			int i = c[0];
			int j = c[1];
			int r = c[2];
			
				//상 
				for(int d=i;d<(i+r > N ? N : i+r);d++) {
					if(tmp[d][j]!=0 && tmp[i][j]!=1) bombs.offer(new int[] {i,d,tmp[i][d]});
					tmp[d][j] = 0;
				}
				//우
				for(int d=j;d<(j+r > N ? N : j+r);d++) {
					if(tmp[i][d]!=0 && tmp[i][d]!=1) bombs.offer(new int[] {i,d,tmp[i][d]});
					tmp[i][d] = 0;
				}
				
				//하
				for(int d=i;d>(i-r < 1 ? 0 : i-r) ;d--) {
					if(tmp[d][j]!=0 && tmp[i][j]!=1) bombs.offer(new int[] {i,d,tmp[i][d]});
					tmp[d][j] = 0;
				}
				
				//좌
				for(int d=j;d> (j-r < 1 ? 0 : j-r) ; d--) {
					if(tmp[i][d]!=0 && tmp[i][d]!=1) bombs.offer(new int[] {i,d,tmp[i][d]});
					tmp[i][d] = 0;
				}
				

			}
			
		
		for(int[] i : tmp)System.out.println(Arrays.toString(i));
		System.out.println("======================");
		System.out.println(Arrays.toString(permArr));
		
	}
	
	static void perm(int depth) {
		
		if(depth==CNT) {
			for(int i=0;i<CNT;i++) calc(permArr[i]);
			return;
		}
		
		
		for(int i=0;i<M;i++) {
		
				permArr[depth] = i;
				perm(depth+1);
			
			}
			
		}
	

}
