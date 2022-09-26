package Septempber_fourth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_16234_인구이동_Gold_5 {
	static int N,L,R; //L명이상 R명 이하면 두 나라가 고융하는 궁격선을 오늘 하루 동안 연다.
					  //일단 먼저 열어놓은거 체크하는 배열이 필요할듯?
	static int[][]map;
	static boolean[][]checkMap;
	static List<int[]> list;
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		checkMap = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				}
		}
	
		
		
		
	}
	
	
	
}
