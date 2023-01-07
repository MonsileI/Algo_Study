package January_First;

import java.util.*;
import java.io.*;

public class bj_1018_체스판다시칠하기_Silver_4 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][]map = new char[N][M];
		
		int answer = 987654321;
		
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		
		for(int x=0;x<N-8+1;x++) {
			for(int y=0;y<M-8+1;y++) {
				
				boolean check = false;
				
				int a = 0;
				int b = 0;
				
				for(int i=x;i<8+x;i++) {
					for(int j=y;j<8+y;j++) {
						
						if(check) {
							if(map[i][j]=='B') a++;
						}else {
							if(map[i][j]=='W') a++;
						}
						 
						check = !check;
						
						if(check) {
							if(map[i][j]=='B') b++;
						}else {
							if(map[i][j]=='W') b++;
						}						
					}
					check = !check;
				}
				
				answer = Math.min(answer, Math.min(a, b));
				
			}
		}
		
		System.out.println(answer);
	}

}
