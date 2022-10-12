package October_second;

import java.io.*;
import java.util.*;
public class Solution_5643_키순서_D5_DFS_Memoization {
	
	static int N,M;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=TC;t++) {
			
			N= Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			int[][] adjMatrix = new int[N+1][M+1]; // 학생번호 1부터 처리
		
			for(int i=1;i<=N;i++) adjMatrix[i][0] = -1;
			
			
			StringTokenizer st = null;
			
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; //a보다 b가 키가 크다
				
			}
			
			
			
			
			int answer = 0;

			for(int i=1;i<=N;i++) { //모든 학생을 탐색의 시작점으로 하여 반복
				if(adjMatrix[i][0]==-1)DFS(i, adjMatrix);
			}
			
			// 모든 정점이 알고 있는 관계로 탐색을 마친 상태 (큰 정점을 따라 탐색해서 간접관계를 직점관계로 다 반영해서 인접행렬에 update)
			// 열 기준 정보를 확인하면 자신보다 작은 정점을 파악 가능
			for(int k=1;k<=N;k++) {
				
				for(int i=1;i<=N;i++) {
					adjMatrix[0][k] += adjMatrix[i][k];
				}
			}
			
			for(int k=1;k<=N;k++) {
				if(adjMatrix[k][0] + adjMatrix[0][k] == N-1) answer++;
			}
			
			System.out.println(answer);
		}
			
	}
	static void DFS(int cur,int[][]adjMatrix){ //cur 학생부터 자신보다 키가 큰 학생따라 탐색
		
	
		
		for(int i=1;i<=N;i++){
			if(adjMatrix[cur][i]==1 ) {
				if(adjMatrix[i][0] == -1) DFS(i,adjMatrix); //나보다 큰 i가 탐색을 하지 않은상태면 탐색 go
				
				//나보다 큰 정점의 탐색정보를 메모
				
				if(adjMatrix[i][0] >0) { //i보다 큰 정점이 존재 : cur <i <j 를 만족하는 j존재 ==> cur <j 상태로 메모
					for(int j=1;j<=N;j++) {
						if(adjMatrix[i][j]==1) adjMatrix[cur][j]=1;
					}
				}
			
			}
		}
		//자신보다 큰 정점의 탐색을 모두 완료하여 메모하기
		int cnt = 0;
		for (int k = 0; k <=N; k++) cnt += adjMatrix[cur][k]; //1의 개수만큼 더해짐!	
		
		adjMatrix[cur][0] = cnt;
		
		
		
		
	}

	

}
