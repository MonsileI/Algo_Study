package August_third;

import java.util.*;
import java.io.*;

// 내구도 감소(로봇이 어떤 칸으로 이동하거나 로봇을 올리는 위치에 올리거나)

//1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
//2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동, 없다면 가만히 있음
//   이동하려는 칸에는 내구도가 1 이상, 로봇이 없어야 함
//3. 올리는 위치가 내구도가 1 이상이면 로봇을 올림
//4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정 종료, 아니면 1번으로 ㄱㄱ


public class bj_20055_컨베이어벨트위의로봇_Gold_5 {

	static int N;
	static int K;
	//벨트 배열
	static int [] map;
	//로봇이 올라가 있는 배열을 따로 선언하는게 괜찮을듯?
	static int [] rob;
	static boolean flag;
	
	static void fourth() {
		
		int sum = 0;
		for(int i=0;i<N*2;i++) if(map[i]==0) sum++;
		if(sum>K-1) flag =true;
		
		
		//로봇 내려주기!
		rob[N-1] = 0;
					
		
	}
	
	static void third() {
		
		if(map[0]>0) {
			rob[0] = 1;
			map[0]--;
		}
		
		
		//로봇 내려주기!
		rob[N-1] = 0;
					
	
	}
	
	static void second() {
		
		for(int i=0;i<N-1;i++) {
			if(rob[i]!=0 && rob[i+1]==0) {
				if(map[i+1]>0) {
					map[i+1]--;
					rob[i+1] = rob[i]; 
					rob[i] = 0;
				}
			}
		}
		
	//로봇 내려주기!
		
	rob[N-1] = 0;
				
		
	}
	
	static void first() {
		
		int []tmpM = new int[N*2];
		int []tmpR = new int[N];
		for(int i=1;i<N*2;i++) tmpM[i] = map[i-1];
		for(int i=1;i<N;i++) tmpR[i] = rob[i-1];	
		
		
		//마지막꺼를 처음으로 넣어주기
		tmpM[0] = map[(N*2)-1];
		
		
		map = tmpM;
		rob = tmpR;
		
		//로봇 내려주기!
		
		rob[N-1] = 0;
				
		
	}
	
	public static void main(String[] args) throws Exception {
		
		//point -> 올리는 위치에 (0 index), 내리는 위치에 N -1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N*2];
		rob = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N*2;i++) map[i] = Integer.parseInt(st.nextToken());
		
		int depth = 1;
		
		while(true) {
		
					
			first(); //회전하는 메소드
				
			
			second(); //가장 먼저 올라간 로봇부터 벨트가 회전하는 방향으로 이동(가능하다면)
		
			
			third(); //로봇 올리기(내구도가 0이 아니라면!)
			
		
			
			fourth(); //내구도가 0인 칸의 개수가 k개 이상이라면 과정 종료
			
			if(flag) break;
			
			depth++;

		}
		
		System.out.println(depth);
		
	}
	
}
