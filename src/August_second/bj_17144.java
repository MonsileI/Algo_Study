package August_second;

import java.io.*;
import java.util.*;

public class bj_17144 {
	
	static int map[][];
	static int shark[][];
	static int R;
	static int C;
	static int M;
	static int loc;
	static int answer;
	static int[][]move = {{-1,0},{1,0},{0,1},{0,-1}}; //위 아래 오른 왼
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //상어 수	
		
		map = new int[R][C]; //격자판	
		shark = new int[M+1][5]; //상어 1부터 시작하려고 .. 0은 비워놓을게
		
		for(int i=1;i<M+1;i++) { //상어정보
			
			st = new StringTokenizer(br.readLine()," ");
			
			int r,c,s,d,z; //r c 는 상어 위치, s는 스피드 d는 방향 z 는 크기
			
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1; //인덱스 조정 
			
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken())-1; //인덱스로 위치 조정하기 위한 뺴기
			z = Integer.parseInt(st.nextToken());
			
			int[]tmp = {r,c,s,d,z};
			shark[i] = tmp;
			
		}
		
		//상어 위치 초기화
		
		for(int i =1;i<=M;i++) {
			map[shark[i][0]][shark[i][1]] = i; //맵 좌표에 i'번째' 상어가 들어간다
		}
		//사람 위치도 초기화
		
		loc = 0;
		
		while(loc<C) { //옆으로 다 갈때까지
			
			MoveAndFish();
			sharkMove();
			sharkFight();
		
			loc++;
		}
		
		System.out.println(answer);
		
		
		
	}
	
	//여기서 상어가 같이 있으면 먹어버리자!
	static void sharkFight(){
		
		for(int i=1;i<M;i++) {
			
			if(shark[i][0]==0 && shark[i][1]==0) continue; //샤크 정보에서 위치 정보가 0이면 건너뛰기(잡아 먹힌거니까 ㅠ)
			
			for(int j=i+1;j<=M;j++ ) {
				if(shark[i][0]==shark[j][0] && shark[i][1]==shark[j][1]) { //같은 위치에 있으면
						
						if(shark[i][4] > shark[j][4]) {//더 큰 애를 맵에 넣어준다.
							map[shark[i][0]][shark[i][1]] = i;
							shark[j][0]= 0;
							shark[j][1]= 0;
							
						}else {
							map[shark[i][0]][shark[i][1]] = j;
							shark[i][0]= 0;
							shark[i][1]= 0;
						}
					
				}
			}
			
		}
		
	}

	
	//뭐 바꾸지 말고, 상어 정보만 바꿔놓자(맵에 넣지 말고)
	static void sharkMove() {
		
		//상어들
		for(int s=1;s<=M;s++) {
			
			int i = shark[s][0];
			int j = shark[s][1];
			int speed = shark[s][2]; //얼만큼 이동할건지
			int head = shark[s][3]; //머리 방향이 어디인지
			int newI = i; //새롭게 될 i 인덱스 
			int newJ = j; //새롭게 될 j 인덱스
			
			//위아래로 이동
			if(head<2) {
				
				for(int r=0;r<speed;r++) {
					
					if(newI<=0) head = 1; //0이 되거나 가장 최상값이 되면 머리를 돌려준다
					else if(newI>=R-1) head = 0;
					
					newI += move[head][0];
				}
			//좌우로 이동	
			}else {
				
				for(int c=0;c<speed;c++) {
					
					if(newJ<=0) head = 2;
					else if(newJ>=C-1) head = 3;
					
					newJ += move[head][0];
				}
			}
			
			shark[s][0] = newI;
			shark[s][1] = newJ;
			
		}
		
	
		
	}
	
	//이동 후 낚시 ㅠㅠ
	static void MoveAndFish() {
		
		
		for(int i=0;i<R;i++) {
			
		
			if(map[i][loc]!=0) { //뭔가 들어가 있으면 잡아버린다. 그리고 맵에서 지워주기
				
				answer += shark[map[i][loc]][4];
				shark[map[i][loc]][0]= 0; //샤크 내에서의 정보도 말소
				shark[map[i][loc]][1]= 0;
				map[i][loc] = 0; //맵 정보에서도 말소시키기
				break;
			}
		}
		
		
	}
	
	

}
