package August_lecture;

import java.util.*;
import java.io.*;

public class turningFirst {
	
	static int n;
	static int m;
	static int r;
	static int [][]map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		turn(map);
		
		
	}
	
	static void turn(int[][]map) {
		
		
		for(int tc=0;tc<r;tc++) {
			
			int[][]tmp = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					tmp[i][j] = map[i][j];
				}
			}

			int tmpI = 0;
			int tmpJ = 0;
			
			while(tmpI < n/2 && tmpJ < m/2 ) {
				
				//왼쪽
				for(int j=m-1-tmpJ; j > tmpJ ; j--) {	
					tmp[tmpI][j-1] = map[tmpI][j];
				}
				//아래
				for(int i=tmpI; i < n-1-tmpI; i++) {
					tmp[i+1][tmpJ] = map[i][tmpJ];
				}
				//오른쪽
				for(int j=tmpJ; j< m - 1-tmpJ;j++) {
					tmp[n-1-tmpI][j+1] = map[n-1-tmpI][j];
				}
				//위
				for(int i= n -1- tmpI ; i > tmpI ; i-- ) {
					tmp[i-1][m-1-tmpJ] = map[i][m-1-tmpJ];
				}
				
				tmpI++;
				tmpJ++;
				
			}
			
			deepCopy(tmp);
			
		}
		
		print(map);
	}
	
	static void print(int[][]map) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	static void deepCopy(int[][]tmp) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] =tmp[i][j];
			}
		}
		
	}
}
