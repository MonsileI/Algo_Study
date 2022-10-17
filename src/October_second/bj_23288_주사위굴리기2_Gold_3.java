package October_second;

import java.util.*;
import java.io.*;

/*
 주사위 아랫면 정수 A 주사위 정수 B 비교
 A > B면 이동 방향 90도 시계방향으로 회전
 A < B면 이동 방향 90도 반시계방향으로 회전
 A = B 변화없음
 
 이동할 수 있는 정수 B가 있으면 점수 B * C(이동할 수 있는 칸 수) 가 됨
 
 동작 방식 : 0,0에서 0,1로 이동 , 동서남북 같은 수 이동 + 곱하기(맨 마지막이 li lj가 되면 됨)
 굴르고 나서 다음 방향도 정해야 됨 D필요할듯?
 
 * */

public class bj_23288_주사위굴리기2_Gold_3 {
	static int dice[]; //주사위
	static int N,M,t,map[][],answer;
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int il,jl; //현재위치
	static int d; //굴러갈 위치방향 (0 상 1 우 2하 3좌)
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		il = 0;
		jl = 0;
		d = 1; //처음엔 우측으로 굴러
		
		//처음 주사위 모양
		dice = new int[6];
		dice[0] = 6; //위
		dice[1] = 2; //북
		dice[2] = 3; //동
		dice[3] = 5; //남
		dice[4] = 4; //서
		dice[5] = 6; //아래
		
	
		
		
		
		calc();
		
		System.out.println(answer);
		
	}
	
	static void bfs(int num) {
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {il,jl});
		int cnt = 1; //세어줄 값
		
		while(!q.isEmpty()) {
			int []c = q.poll();
			int i = c[0];
			int j= c[1];
			
			for(int d=0;d<4;d++) {
				int ni = i + move[d][0];
				int nj = j + move[d][1];
				
				if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
				if(map[ni][nj]!=num) continue;
				cnt++;
				
			}
			
		}
		
		answer += (cnt * num);
		
	}
	
	
	static void calc() {
		
		
		while(true) {
			
			
			il = move[d][0]; //굴러가기
			jl = move[d][1]; //굴러가기
			
			//점수 계산
			bfs(map[il][jl]);
			
			//구르기 방향 전환
			
			/*
			  2
			4 1 3      동쪽으로 구르는데 6이면 3   
			  5	               3이면 1
			  6                5이면   
			 
			  
			  */
			
			
			
			
			
			
			
			t--;
			
			if(t==0) return;
			
		}
		
		
	}

	
	static void change(int turn) {
		
		//동쪽으로 구르면
		
		switch (turn) {
		case 0:
			int tmp1 = dice[0];
			int tmp2 = dice[2];
			int tmp3 = dice[5];
			int tmp4 = dice[4];
			dice[0] = tmp2;
			dice[4] = tmp4;
			dice[2] = dice[5];
			dice[5] = dice[4];
			break;
		case 1:
			//서
			
			dice[0] = dice[4];
			dice[2] = dice[0];
			dice[4] = dice[5];
			dice[5] = dice[2];
			
			break;
		case 2:
			//남
			dice[0] = dice[3];
			dice[1] = dice[0]; 
			dice[3] = dice[5]; 
			dice[5] = dice[1];
			
			break;
		case 3:
			//북
			
			dice[0] = dice[1];
			dice[1] = dice[5]; 
			dice[3] = dice[0]; 
			dice[5] = dice[3];
			break;

		}
		

		
	
	}
	
}
