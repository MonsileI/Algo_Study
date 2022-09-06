package September_second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 
 1. 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 가격으로 제공
 2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행, 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥
 	하나를 추가로 무료 제공, 만약 번호가 없다면, 요리사가 새로 만들어 손님에게 제공
 	
 	많이 받을 수 있는거 출력.
 
 
 
 * */
public class bj_2531_회전초밥_Silver_1 {
	static int N,d,k,c; //접시 수, 초밥 가지수, 연속 접시 수, 쿠폰 번호
	static int[]chobab;
	static int answer = Integer.MAX_VALUE;
	static int []tmp;
	static boolean flag;
	
	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		chobab = new int[N];
		tmp = new int[k];
		for(int i=0;i<N;i++) chobab[i] = Integer.parseInt(br.readLine());
		
		
	}
	static void output() {
		System.out.println(answer);
	}
	
	static void check() {
		flag = true;
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(tmp[i]==tmp[j]) return;
			}
			if(tmp[i]==c) flag = false;
		}
		
		if(flag) answer = N+1;
		else answer = N;
		
		
	}
	
	static void combi(int start, int depth) {
		
		if(flag) return;
		
		if(depth==k) {
			check();
			return ;
		}
		
		for(int i=start;i<N;i++) {
			
			tmp[depth] = chobab[i];
			combi(i+1,depth+1);
		}
	}
	
	static void calc() {
		
		//조합해보자
	
		combi(0,0);

	}
	
	public static void main(String[] args) throws Exception{
		input();
		calc();
		output();
		
	}
}
