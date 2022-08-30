package August_third;

import java.io.*;
import java.util.*;

public class bj_2644_촌수계산_Silver_2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int fir = Integer.parseInt(st.nextToken());
		int sec = Integer.parseInt(st.nextToken());
		
		int g = Integer.parseInt(br.readLine());
		int[][]arr = new int[g][2];
		
		for(int i=0;i<g;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<g;i++) {
			if(arr[i][1]==sec) {
				dfs(i);
			}
		}
		
		
		
	}
	static void dfs(int t) {
		
		
		
	}
}
