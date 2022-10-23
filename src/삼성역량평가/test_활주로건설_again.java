package 삼성역량평가;

import java.util.*;
import java.io.*;

public class test_활주로건설_again {
	
	static int N,X;
	static int arr1[][], arr2[][];
	
	
	static int check(int[]map) {
		
		int j = 0;
		int bh = map[0];
		int size = 0;
		
		while(j<N) {
			
			if(map[j]==bh) {
				size++;
				j++;
			}else if(map[j]==bh+1) {
				if(size<X) return 0;
				
				size = 1;
				j++;
				bh++;
				
				
			}else if(map[j]==bh-1) {
				
				int cnt = 0;
				
				for(int k=j;k<N;k++) {
					if(map[k]!=bh-1) return 0;
					if(++cnt==X) break;
				}
				if(cnt<X) return 0;
				j += X;
				size = 0;
				bh--;
				
			}else return 0;
		}
		
		
		return 1;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC= Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			arr1 = new int[N][N];
			arr2 = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr1[i][j] = arr2[j][i] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			int a = 0;
			
			for(int i=0;i<N;i++) {
				a += check(arr1[i]);
				a += check(arr2[i]);
			}
	
			
			
			System.out.println("#"+t+" "+a);

		}
		
			
		
	}

}
