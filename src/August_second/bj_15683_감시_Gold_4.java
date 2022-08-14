package August_second;

import java.io.*;
import java.util.*;
//1번 단방향 4
//2번 양방향 2
//3번 직각 4
//4번 세방향 4
//5번 사방향 1
//combination 문제 같음 각각 number의 콤비네이션을 해줘야함! (1은 4개)->이걸 어떻게 표현할지가 관건일듯?

public class bj_15683_감시_Gold_4 {

	static int N;
	static int M;
	static int[][]map;
	static List<int[]> cList = new ArrayList<>();
	static boolean[]combiVisited;
	//c인덱스 값만 필요함! c인덱스만 뽑아주면 될듯
	static int[][]arr;
	static int answer;
	static boolean[][]visited;
	
	
	static void first(int[][][]list) {
		
		
	}
	static void second(int[][][]list) {
		
	}
	static void third(int[][][]list) {
		
	}
	static void fourth(int[][][]list) {
		
	}
	static void fifth(int[][][]list) {
		
	}
	

	
	//콤비네이션 만드는 메소드
	
	static void comb(int idx,int start,int depth) {
		
		if(depth==arr.length) {
			
			
			
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
																	//좌표값 + 카메라종류 
				if(!(map[i][j]==0 || map[i][j]==6)) cList.add(new int[] {i,j,map[i][j]});
					
				
				}
			}
		
		combiVisited = new boolean[cList.size()];
		arr = new int[cList.size()][2];
		comb(0,0,0);
		
		
	}
}
