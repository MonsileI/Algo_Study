package December_first;

import java.util.*;
import java.io.*;

public class bj_1138_한줄로서기_Silver_2 {

	static int N,arr[];
	static int[]tmp;
	static boolean[] visited;
	static boolean flag;
	static StringBuilder sb;
	static void perm(int depth) {
	
		if(flag) return;
		
		if(depth==N) {
			
			for(int i=0;i<N;i++) {
				int tmpNum = tmp[i];
				int checkNum = arr[tmpNum];
				int cnt = 0;
				
				for(int j=0;j<i;j++) {
					if(tmpNum<tmp[j]) cnt++;
					if(cnt>checkNum) return;
				}
				if(cnt!=checkNum) return;
			}
			
			flag = true;
			for(int i=0;i<N;i++) {
				if(i==N-1) sb.append(tmp[i]+1);
				else sb.append((tmp[i]+1)+" ");
			}
			
			return;
		}
		
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[depth] = i;
				perm(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N  = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		arr = new int[N];
		visited = new boolean[N];
		tmp = new int[N];
		flag = false;
		sb = new StringBuilder();
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());	
		
		perm(0);
		
		System.out.println(sb.toString());

	}
}
