package September_third;

import java.io.*;
import java.util.*;

public class bj_3020_개똥벌레_Gold_5 {

	static int N;
	static int H;
	static int [] top;
	static int [] bot;
	static int min;
	static int cnt;
	
	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		bot = new int[H+1];
		top = new int[H+1];
		min = N;
		cnt = 0;
		
		for(int i=0;i<N/2;i++) {
			bot[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
		
	
	}
	
	static void calc() {
		
		//누적합
		for(int i= H-1; i > 0 ; i--) {
			top[i] += top[i+1];
			bot[i] += bot[i+1];
		}
		int[]stone = new int[H+1];
		int min = N+1;
		
		for(int i=1;i<=H;i++) {
			stone[i] = bot[i] + top[H-i+1];	
			min = Math.min(min, stone[i]);
		}
		int cnt = 0;
		for(int i=1;i<=H;i++) {
			if(stone[i]==min) cnt++;
		}
		
		
		System.out.println(min+" "+cnt);
	}
	
		
	
	public static void main(String[] args)throws Exception {
		input();
		calc();
	
	}
}
