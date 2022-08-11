package August_second;

import java.io.*;
import java.util.*;
//1번 단방향
//2번 양방향
//3번 직각
//4번 세방향
//5번 사방향
public class bj_15683_감시_Gold_4 {

	static int N;
	static int M;
	static int[][]map;
	
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
			}
		}
		
		
	}
}
