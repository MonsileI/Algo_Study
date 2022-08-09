package August_second;

import java.io.*;
import java.util.*;

public class fishing {
	
	static ArrayList<int[]> shark;
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
		
		shark = new ArrayList<>();
		
		for(int i=0;i<M;i++) { //상어정보
			
			st = new StringTokenizer(br.readLine()," ");
			
			int r,c,s,d,z; //r c 는 상어 위치, s는 스피드 d는 방향 z 는 크기
			
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1; //인덱스 조정 
			
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken())-1; //인덱스로 위치 조정하기 위한 뺴기
			z = Integer.parseInt(st.nextToken());
			
			int[]tmp = {r,c,s,d,z};
			shark.add(tmp);
			
		}
		
	
		//사람 위치 초기화
		
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
		
		
		
	}

	
	//뭐 바꾸지 말고, 상어 정보만 바꿔놓자
	static void sharkMove() {
		
		for(int [] s : shark) {
			
			int i = s[0];
			int j = s[1];
			int speed = s[2];
			int head = s[3];
			
			int newI = i;
			int newJ = j;
			
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
			
			s[0] = newI;
			s[1] = newJ;
	
		}
		
	
		
	}
	
	//이동 후 낚시 ㅠㅠ
	static void MoveAndFish() {
		
		int s = Integer.MAX_VALUE;
		
		for(int [] i : shark) {
			
			if(loc==i[1]) {
				s = Math.min(i[0], s);
			}
			
		}
		
		for(int [] i : shark) {
			
			if(i[1]==loc && i[0]==s) shark.remove(i);
			
		}
		
		
	}
	
}
