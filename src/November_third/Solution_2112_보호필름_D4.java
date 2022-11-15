package November_third;

import java.util.*;
import java.io.*;

public class Solution_2112_보호필름_D4 {

	static int N,M,K,map[][];
	static int visited[];
	static int answer;
			
	
	static void calc(int sum) {
		
		//0번째는 기준점이 필요하기 때문에 따로 빼 놓는다!
		boolean flag = false;
		
		for(int j=0;j<M;j++) {
			
			//flag 비교 쿼리
			flag = false;
			
			int count = 1; //숫자 몇번 유지되는지 확인하는 변수
			
			//아무일도 없으면 그냥 원래 값 유지
			int checkNum = map[0][j];
			//1로 바꾸기로 했으면 전부 1로 바꿔주기
			if(visited[0]==1) checkNum = 1;
			else if(visited[0]==-1) checkNum = 0; 			//반대의 경우 0으로 바꿔주기
			
			innerLoop:
			for(int i=1;i<N;i++) {
				
				int tmpNum = map[i][j];
				//1로 바꾸기로 했으면 전부 1로 바꿔주기
				if(visited[i]==1) tmpNum = 1;
				else if(visited[i]==-1) tmpNum = 0; 			//반대의 경우 0으로 바꿔주기

				if(tmpNum==checkNum) count++;
				else {
					count = 1;
					checkNum = tmpNum;
				}
				if(count==K) {
					flag = true;
					break innerLoop;
				}
			}
			if(!flag) return;
			
		}
	
		answer = Math.min(answer, sum);
	}
	
	
	static void sub(int depth, int sum) {
		
		//프루닝
		if(answer<=sum) return;
		
		//조건식
		if(depth==N) {
			calc(sum);
			return;
		}

		//sub==========================================
		
		//안바꾸는 경우
		visited[depth] = 0;
		sub(depth+1,sum);
		//0으로 바꾸는 경우
		visited[depth] = -1;
		sub(depth+1,sum+1);
		//1로 바꾸는 경우
		visited[depth] = 1;
		sub(depth+1,sum+1);
	
	}
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			answer = Integer.MAX_VALUE;
			visited = new int[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sub(0,0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
