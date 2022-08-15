package August_second;

import java.util.*;
import java.io.*;

//1번 단방향
//2번 양방향
//3번 직각
//4번 삼방향
//5번 사방향

public class test {

	static int N;
	static int M;
	static int[][]map;
	static List<int[]>cctvList = new ArrayList<>();
	static int [][]mov = {{-1,0},{0,1},{1,0},{0,-1}};
	static int [][][]func = { {{}} , {{0},{1},{2},{3}} , {{0,2},{1,3}} ,{{0,1},{1,2},{2,3},{3,4}},
									 {{0,1,2},{1,2,3},{2,3,0},{0,3,1}}, {{0,1,2,3}}  };
	static int answer = Integer.MAX_VALUE;
	
	static int check(int[][]map) {
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}
	
	static void combi(int depth,int[][]map) {
			
		if(depth==cctvList.size()) {
			
		}
		
		for(int i=0;i<cctvList.size();i++) {
			
			
			int type = cctvList.get(i)[2];
		
			int[][]tmp = new int[cctvList.size()][func[type].length];
			
			for(int j=0;j<func[type].length;j++) {
				
				
				
			}
			
		}
		
		
	}
	
	static void input() throws Exception {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(!(map[i][j]==0 || map[i][j]==6)) {
					cctvList.add(new int[] {i,j,map[i][j]});
				}
					
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		input();
		
		combi(0,map);
		
	}
}
