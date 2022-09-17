package September_third;

import java.util.*;
import java.io.*;

//N개의 물건은 각각 w의 무게와 가치v를 가짐, 
// 준서는 k만큼의 무게만 넣을 수 있음
// 가치의 최대값 구하기

public class Main_bj_12865_평범한배낭_Gold_5 {
	static int N,K;
	static int[][]beg;
	static int answer = -123;
	static boolean[]visited;
	static void input()throws Exception{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		beg = new int[N][2];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			beg[i][0] = Integer.parseInt(st.nextToken());
			beg[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	static void output() {
		System.out.println(answer);
	}
	
	static void calc() {
		
		dfs(0,K,0);
		
		
		
	}
	
	static void dfs(int depth,int weight,int sum) {
		
		if(depth==N) {
			answer = sum;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && beg[i][0] <= weight) {
				visited[i] = true;
				int Nweight = weight - beg[i][0];
				int newK = sum + beg[i][1];
				dfs(depth+1, Nweight, newK);
				visited[i] = false;
			}
		}
			
		answer = Math.max(answer, sum);
	}
	
	public static void main(String[] args) throws Exception{
		input();
		calc();
		output();
		
	}
}
