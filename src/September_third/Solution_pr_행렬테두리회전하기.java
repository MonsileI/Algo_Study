package September_third;

import java.util.*;

public class Solution_pr_행렬테두리회전하기 {
	
	public static void main(String[] args) {
		
		int rows = 6;
		int columns = 6;
		int[][]queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[]answer = new int[queries.length];
		
		int[][]map = new int[rows][columns];
		int[][]tmp = new int[rows][columns];
		int num = 1;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				map[i][j] = num++;
				tmp[i][j] = num;
			}
			
		}
		
		for(int d=0;d<queries.length;d++) {
			
			
			for(int i=0;i<rows;i++)
				for(int j=0;j<columns;j++)
					tmp[i][j] = map[i][j];
			
			int i1 = queries[d][0]-1;  
			int j1 = queries[d][1]-1;
			int i2 = queries[d][2]-1;
			int j2 = queries[d][3]-1;
			
			System.out.println(i1);
			System.out.println(j1);
			System.out.println(i2);
			System.out.println(j2);
			int minNum = Integer.MAX_VALUE/2;
			
			for(int i=i1;i<=i2;i++) {
				if(map[i][j1] <minNum) minNum=map[i][j1];
				if(map[i][j2] <minNum) minNum=map[i][j2];
				
			}
			for(int j=j1;j<=j2;j++) {
				if(map[i1][j]<minNum) minNum = map[i1][j];
				if(map[i2][j]<minNum) minNum = map[i2][j];
			}
			
			answer[d] = minNum;
			//위 오른
			for(int c=j1;c<j2;c++) tmp[i1][c+1] = map[i1][c];
			
			//아래 오른
			for(int c=i1;c<i2;c++) tmp[c+1][j2] = map[c][j2];
	
			//아래 왼
			for(int c=j2;c>j1;c--) tmp[i2][c-1] = map[i2][c];
		
			//위 왼
			for(int c=i2;c>i1;c--) tmp[c-1][j1] = map[c][j1];
			
			
			for(int i=0;i<rows;i++)
				for(int j=0;j<columns;j++)
					map[i][j] = tmp[i][j];
			
			
		}
		
		
	}
	
}