package 삼성역량평가;

import java.io.*;
import java.util.*;

public class bj_2239_스도쿠_Gold_4 {
	static List<int[]> list = new ArrayList<>();
	static boolean flag = false;
	static int [][]map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		
		for(int i=0;i<9;i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0;j<9;j++) {
				map[i][j]= ch[j] - '0';
				if(map[i][j]==0) list.add(new int[] {i,j});
			}
		}
		
		dfs(0);
		
		
	}
	
	static void output() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	static void dfs(int idx) {
		
		if(flag)return;
		if(idx==list.size()) {
			output();
			flag =  true;
			return;
		}
		
		for(int num=1;num<10;num++) {
			
			if(check(idx,num)) {
				map[list.get(idx)[0]][list.get(idx)[1]] = num;
				dfs(idx+1);
			}
			
			if(num==9) map[list.get(idx)[0]][list.get(idx)[1]] = 0;
	
		}
		
	}
	static boolean check(int idx, int num) {
		
		int i = list.get(idx)[0];
		int j = list.get(idx)[1];
		
		//가로
		for(int d=0;d<9;d++) {
	
			if(map[i][d]==0) continue;
			if(num==map[i][d]) return false;
		
		}
		
		//세로
		for(int d=0 ; d<9;d++) {
			
			if(map[d][j]==0) continue;
			if(num==map[d][j]) return false;
		}
		//네모
		
		int ti = i/3;
		int tj = j/3;
		ti *= 3;
		tj *= 3;
		
		for(int r=ti;r<ti+3;r++) {
			for(int c=tj;c<tj+3;c++) {
				if(map[r][c]==0) continue;
				if(map[r][c]==num) return false;
			}
		}
		
		return true;
		
	}

}
