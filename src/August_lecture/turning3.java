package August_lecture;

import java.util.*;
import java.io.*;

public class turning3 {
	
	static int n;
	static int m;
	static int [][]tmp;
	static int [][]map;
	
	public static void main(String[] args) throws Exception {
		
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int tc = Integer.parseInt(st.nextToken());
		
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," "); 
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t=0;t<tc;t++) {
			
			int num = Integer.parseInt(br.readLine());
			
			switch (num) {
			case 1:
				first();
				break;
			case 2:
				second();
				break;
			case 3:
				third();
				break;
			case 4:
				fourth();
				break;
			case 5:
				fifth();
				break;
			case 6:
				sixth();
				break;

			}
		}
		
		print();
		
		
	}
	
	static void print() {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	

		
	static void first() {
		
		int[][]tmp = new int[n][m];
		
		for(int i = 0 ; i< n;i++) {
			for(int j=0;j<m;j++) {
				tmp[i][j] = map[(n-1)-i][j];
			}
		}

		
		map = tmp;
		
	}
		
	static void second() {
		
		int[][]tmp = new int[n][m];
		
		for(int i = 0 ; i< n;i++) {
			for(int j=0;j<m;j++) {
				tmp[j][n-1-i] = map[i][i];
			}
		}

		map = tmp;
		
	}
		
	static void third() {
		
		int[][]tmp = new int[m][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmp[j][n-i-1] = map[i][j];
			}
		}
		map = new int[m][n];
		map = tmp;
		
	
	}
	static void fourth() {
		
	}
	static void fifth() {
	
	}

	static void sixth() {
		
	}
		

}
