package 삼성역량평가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님_D5 {
	
	static char map[][];
	static int N,M;
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			
			Queue<int[]> devil = new LinkedList<>();
			Queue<int[]> suyeon = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N =Integer.parseInt(st.nextToken());
			M =Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				map[i]= str.toCharArray();
				for(int j=0;j<M;j++) {
					if(map[i][j]=='*') 	{
						devil.offer(new int[] {i,j});					
					}
					else if(map[i][j]=='S')	{
						suyeon.offer(new int[] {i,j});
					}
				}
			}
			boolean flag=false;
			int result=0;
		
			while(true) {
				//악마 이동
				int len = devil.size();
				for(int c=0;c<len;c++) {
					int []cir = devil.poll();
					int i = cir[0];
					int j = cir[1];
					for(int d=0;d<4;d++) {
						int ni = i + move[d][0];
						int nj = j + move[d][1];
						if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
						if(map[ni][nj]=='.' || map[ni][nj]=='S') {
							map[ni][nj]='*';
							devil.offer(new int[] {ni,nj});
						}
					}
				}
				//수연이 이동
				len = suyeon.size();
				for(int c=0;c<len;c++) {
					
					int []cir = suyeon.poll();
					int i = cir[0];
					int j = cir[1];
					if(map[i][j]=='D') {
						flag= true;
						break;
					}
					
					for(int d=0;d<4;d++) {
						
						int ni = i + move[d][0];
						int nj = j + move[d][1];
						if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
						if(map[ni][nj]=='.' || map[ni][nj]=='D'){
							if(map[ni][nj]!='D') map[ni][nj] = 'S';
							suyeon.offer(new int[] {ni,nj});
							
						}
					}	
					
				}
				if(flag || suyeon.isEmpty()) break;				
				result++;
			}
			
			if(!flag) System.out.println("#"+t+" "+"GAME OVER");
			else System.out.println("#"+t+" "+result);
			
		}
	}
	
}