package August_lecture;

import java.util.*;
import java.io.*;


public class HomeWorkArray {
	
	static int n;
	static int m;
	static int k;
	static int[][]map; //원래 맵
	static int[][]tmp; //임시 맵
	static int answer = Integer.MAX_VALUE; //정답 초기화
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken()); //콜 i
		m = Integer.parseInt(st.nextToken()); //로우 j
	    k = Integer.parseInt(st.nextToken()); //회전 연산 개수
		
	    map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		int[][]arr = new int[k][3];
		//연산 횟수
		for(int tc=0;tc<k;tc++) {
			
			
			st = new StringTokenizer(br.readLine()," ");
			
			//-1로 인덱스 ㅡ조정하기
			int r = Integer.parseInt(st.nextToken())-1; //로우
			int c = Integer.parseInt(st.nextToken())-1; //콜
			int s = Integer.parseInt(st.nextToken()); //r-s ~ r+s
			
			arr[tc][0] = r;
			arr[tc][1] = c;
			arr[tc][2] = s;

			
		}
		int[]list = new int[k];
		boolean[]visited = new boolean[k];
		dfs(list,arr,visited,0);
		System.out.println(answer);
		
		
	}
	static void turn(int[]list,int[][]arr) {
		
		int [][]board = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				board[i][j] = tmp[i][j];
			}
		}
		
		for(int l=0;l<list.length;l++) {
			
			int r = arr[list[l]][0];
			int c = arr[list[l]][1];
			int s = arr[list[l]][2];
			
			while(s>0) {
				
				
				//오른쪽 회전
				for(int j =c-s; j < c+s;j++) tmp[r-s][j+1] = board[r-s][j];
				//아래 회전
				for(int i=r-s; i < r+s ; i++) tmp[i+1][c+s] = board[i][c+s];
				//왼쪽 회전
				for(int j=c+s; j>c-s;j--) tmp[r+s][j-1] = board[r+s][j];
				//위쪽 회전
				for(int i=r+s; i > r-s; i--) tmp[i-1][c-s] = board[i][c-s];
			
				s--;
				
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					board[i][j] = tmp[i][j];
				}
			}
			
		}
		
		cal(tmp);
		
	}
	
	static void cal(int[][]tmp) {
		for(int i=0;i<n;i++) {
			int sum = 0;
			for(int j=0;j<m;j++) {
				sum += tmp[i][j];
			}
			if(sum<answer)answer=sum;
		}
	}
	
	
	static void dfs(int[]list,int[][]arr,boolean[]visited,int depth) {
		
		if(depth==k) {
			tmp = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					tmp[i][j] = map[i][j];
				}
			}
			turn(list,arr);
		}
		
		
		for(int i=0;i<k;i++) {
			if(!visited[i]) {
				visited[i] = true;
				list[depth] = i;
				dfs(list,arr,visited,depth+1);
				visited[i] = false;
			} 
		}
		
		
		
		
		
		
		
	}
	

}
