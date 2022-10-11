package October_second;

import java.io.*;
import java.util.*;
public class Solution_5643_키순서_D5_DFS {
	
	static int N,M, adjMatrix[][];
	static int gtCnt, ltCnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=TC;t++) {
			
			N= Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][M+1]; // 학생번호 1부터 처리
			
			StringTokenizer st = null;
			
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; //a보다 b가 키가 크다
			}
			
			
			
			
			int answer = 0;

			for(int i=1;i<=N;i++) { //모든 학생을 탐색의 시작점으로 하여 반복
				gtCnt = ltCnt = 0; //초기화
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if(gtCnt+ltCnt==N-1) answer++;
			}
			
			System.out.println(answer);
		}
			
	}
	static void gtDFS(int cur,boolean[]visited){ //cur 학생부터 자신보다 키가 큰 학생따라 탐색
		
	
		
		visited[cur] = true;
	
		for(int i=1;i<=N;i++){
			if(adjMatrix[cur][i]==1 && !visited[i]) { //i가 cur보다 키가 크고 아직 탐색되지 않았다면
				gtCnt++;
				gtDFS(i,visited);
			}
		}
			
		
		
		
	}
	
	static void ltDFS(int cur,boolean[]visited){ //cur 학생부터 자신보다 키가 작은 학생따라 탐색
		
	
		
		visited[cur] = true;
	
		for(int i=1;i<=N;i++){
			if(adjMatrix[i][cur]==1 && !visited[i]) { //i가 cur보다 키가 크고 아직 탐색되지 않았다면
				ltCnt++;
				ltDFS(i,visited);
			}
		}
			
		
		
		
	}

}
