package September_third;

import java.util.Arrays;

/*
 * 
5,5,5,5,5
5,5,5,5,5
5,5,5,5,5
5,5,5,5,5

100344
120232
210312
101331

type r1 c1 r2 c2 degree

1일경우 -> 공격 2일 경우 -> 회복

result 10
 * 
 * */

public class pr_파괴되지않는건물 {

	
	
	public static void main(String[] args) {
		Solution_파괴되지않는건물 solution = new Solution_파괴되지않는건물();
		int [][]board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int [][]skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		System.out.println(solution.Solution(board,skill));
	}

}

class Solution_파괴되지않는건물{
	
	static int[][]map;
	
	static void calc(int[]skill) {
		
		int type = skill[0];
		int r1 = skill[1];
		int c1 = skill[2];
		int r2 = skill[3];
		int c2 = skill[4];
		int degree = skill[5];
		
		int method = 0;
		
		if(type==1) method = -1;
		else method = 1;
		
		for(int i=r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
				map[i][j] += degree * method;
			}
		}
		
		
		
		
	}
		
	static int Solution(int[][]board, int[][]skill) {
	
	int answer = 0;
	map = board;
	
	for(int i=0;i<skill.length;i++) calc(skill[i]);
	
	for(int i=0;i<map.length;i++) {
		for(int j=0;j<map[0].length;j++) {
			if(map[i][j]>0) answer++;
		}
	}
		
	return answer;
	}
}