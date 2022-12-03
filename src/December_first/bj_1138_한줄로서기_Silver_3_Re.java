package December_first;

import java.util.*;
import java.io.*;

public class bj_1138_한줄로서기_Silver_3_Re {

	static int N, arr[];
	static List<Integer> list;

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N  = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		arr = new int[N];
		
	
		list = new ArrayList<>();
		
		for(int i=0;i<N;i++) arr[i]= Integer.parseInt(st.nextToken());	
			
		for(int i = N-1;i>-1;i--) {
			int c = arr[i];
			list.add(c, i+1);
		}
	
		for(int i  :list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
		
		
		

	}
}
