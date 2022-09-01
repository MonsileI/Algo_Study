package August_third;

import java.util.*;
import java.io.*;

/*
 x는 행 j
 y는 열  i
 
 쓰이는 블록 모양은 하나, 두 개가 가로 또는 두개가 세로
 
 블록을 놓을 위치
 1. 빨간색 보드에서 선택하면, 그 위치부터 초록색 보드로 블록이 이동, 파란색 보드로 블록이 이동
 (다른 블록을 만나거나 보드의 경계를 만나기 전까지 계속해서 이동)
2. 초록색은 행이 가득 차 있으면 그 행들 다 제거. 제거되고 남은 애는 밑에 붙여준다 
 	파란색은 열이 가득 차 있으면 그 열을 다 제거. 제거되고 남은 애는 오른쪽으로 붙여준다
4. 사라진 열이나 행의 수만큼 +1 해준다.
5. 초록색 혹은 파란색의 0,1열에 블록이 놓이면, 그 블록이 놓인 것만큼 가장 아래 열,행이 사라지고
    모든 블록들은 이동하게 된다.
 
 **** 행이나 열이 타일로 가득찬 경우와 연한 칸에 블록이 있는 경우가 동시에 발생할 수 있다.
 * 이 경우에는 행이나 열이 타일로 가득 찬 경우가 없을 때까지 점수를 획득하는 과정이 모두 진행된 후,
 *  연한 칸에 블록이 있는 경우를 처리해야 한다.
 *  
 ===============================================================
 
 입력 : 첫째줄 블록을 놓은 횟수
 	  둘쨰줄 부터 정보 t x y 
 	  t = 1: 크기가 1×1인 블록을 (x, y)에 놓은 경우 반대로 또 받아야겠다 x y 그래도! 0부터 시작 개꿀
	  t = 2: 크기가 1×2인 블록을 (x, y), (x, y+1)에 놓은 경우
	  t = 3: 크기가 2×1인 블록을 (x, y), (x+1, y)에 놓은 경우
 * */



public class bj_20061_모노미노도미노2_Gold_2 {
	
	static int[][] cal;
	static int[][] green;
	static int[][] blue;
	
	
	static void input() throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		cal = new int[n][3];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			cal[n][0] = Integer.parseInt(st.nextToken());
			cal[n][2] = Integer.parseInt(st.nextToken()); //i j 값으로 변환!
			cal[n][1] = Integer.parseInt(st.nextToken());
		}
		
		green = new int[4][6];
		blue = new int[6][4];
		
	}
	static void output() {
		
	}
	
	static void oper() {
		
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
	
		input();
		oper();
		output();
	}
	
}
