package January_First;

import java.util.*;
import java.io.*;

public class 거짓말 {
					
	static int N,P,NP,npArr[],pArr[][]; //사람, 파티, 아는사람 수, 아는사람arr,파티 정보arr
	static boolean tpArr[]; //아는 사람 boolean
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		st=  new StringTokenizer(br.readLine()," ");
		int NP = Integer.parseInt(st.nextToken());
		npArr = new int[NP];
		tpArr = new boolean[N];
		for(int i=0;i<NP;i++) {
			npArr[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		
		pArr= new int[P][];
		
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int size = Integer.parseInt(st.nextToken());
			pArr[i] = new int[size];
			for(int j=0;j<size;j++) {
				pArr[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		//=============여기까지 인풋=====================
		
		for(int i=0;i<NP;i++) {
			dfs(npArr[i]);
		}
		int answer = 0;
		for(int i=0;i<P;i++) {
			int size = pArr[i].length;
			for(int j=0;j<size;j++) {
				if(!tpArr[pArr[i][j]]) {
					answer++; 
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int person) {
		
		for(int i=0;i<P;i++) {
			int size = pArr[i].length;
			boolean flag = false;
			for(int j=0;j<size;j++) {
				if(person==pArr[i][j]) {
					
					flag = true;	
					break;
				}
			}
			
			if(flag) {
				for(int j=0;j<size;j++) {
					if(!tpArr[pArr[i][j]]) {
						tpArr[pArr[i][j]] = true;
						dfs(pArr[i][j]);						
					}
				}
			}
		}
	}

}
