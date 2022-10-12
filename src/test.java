import java.io.*;
import java.util.*;

public class test {


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][]arr = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = true;
		}
		
		for(int k=1;k<N+1;k++) {
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					arr[i][j] = arr[i][j] || (arr[i][k] && arr[k][j]);
				}
			}
		}
		
		
		int answer = 0;
		
		outerLoop:
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(i==j) continue;
				if(!arr[i][j] && !arr[j][i]) continue outerLoop; 
			}
			answer++;
		}
		
		
		System.out.println(answer);
	}
}
