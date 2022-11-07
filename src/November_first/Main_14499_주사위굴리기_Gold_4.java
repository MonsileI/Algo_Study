package November_first;

import java.util.*;
import java.io.*;

public class Main_14499_주사위굴리기_Gold_4 {

	static int N,M,K,map[][];
	static int di,dj;
	static int []dice = {0,0,0,0,0,0}; //위 아래 상 우 하 좌
	static int [][]move = {{},{0,1},{0,-1},{-1,0},{1,0}};
	static void calc(int order) {
		
		int ni = di +  move[order][0];
		int nj = dj +  move[order][1];
		
		
		if(ni<0||nj<0||N-1<ni||M-1<nj) return;
		
		di = ni;
		dj = nj;
		
		int up = dice[0]; //위
		int down = dice[1]; //아래
		int w = dice[2]; //상
		int d = dice[3]; //우
		int s = dice[4]; //하
		int a = dice[5]; //좌
		
		switch (order) {
		//동 서 남 북
		case 1:dice[0] = a;
			   dice[3] = up;
			   dice[1] = d;
			   dice[5] = down;
			break;
		case 2: dice[0] = d;
				dice[3] = down;
				dice[1] = a;
				dice[5] = up;
			break;

		case 4: dice[0] = w;
				dice[1] = s;
				dice[2] = down;
				dice[4] = up;
			break;

		case 3: dice[0] = s;
				dice[1] = w;
				dice[2] = up;
				dice[4] = down;
			break;
		}
		
		if(map[di][dj]==0) {
			map[di][dj] = dice[1];
		}else {
			dice[1] = map[di][dj];
			map[di][dj] = 0;
		}
		System.out.println(dice[0]);
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		di = Integer.parseInt(st.nextToken());
		dj = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<K;i++) calc(Integer.parseInt(st.nextToken()));
		
	}
}
