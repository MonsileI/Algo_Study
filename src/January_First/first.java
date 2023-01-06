package January_First;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class first {

	static int answer = 0;
	static int n,k,p,x;
	static int[]digit_x;
	
	static int[][]num = {{1,1,1,1,1,1,0},
			{0,1,1,0,0,0,0},
			{1,1,0,1,1,0,1},
			{1,1,1,1,0,0,1},
			{0,1,1,0,0,1,1},
			{1,0,1,1,0,1,1},
			{1,0,1,1,1,1,1},
			{1,1,1,0,0,0,0},
			{1,1,1,1,1,1,1},
			{1,1,1,1,0,1,1}};
	
	
	static int[]change_to_digit(int c){
		
		int [] arr = new int[k];
		
		for(int i=k-1; i > -1; i--) {
			arr[i] = c % 10;
			c /= 10;
		}

		
		return arr;
		
	}
	
	static boolean canReverse(int floor) {
		
		int change = 0;
		int [] digit_f = new int[k];
		digit_f = change_to_digit(floor);
		
		  for(int i = 0; i < k; i++) {
	            for(int j = 0; j < 7; j++) {
	                if(num[digit_x[i]][j] != num[digit_f[i]][j]) {
	                    change++;
	                    if(change > p) return false;
	                }
	            }
	        }
	        return true;
	}
	
	static void check() {
		for(int i=1;i<=n;i++) {
			if(i==x)continue;
			if(canReverse(i)) answer++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
	
		int N = Integer.parseInt(st.nextToken()); //최대층수 1부터
		int K = Integer.parseInt(st.nextToken()); //LED 개수
		int P = Integer.parseInt(st.nextToken()); //변경 개수
		int X = Integer.parseInt(st.nextToken()); //현재층수
		
		n = N;
		k = K;
		p = P;
		x = X;
		
		digit_x = change_to_digit(X);
		check();
		System.out.println(answer);
		
	}
	
}
