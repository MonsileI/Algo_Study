import java.io.*;
import java.util.*;

public class test {

<<<<<<< HEAD

=======
	
	
>>>>>>> branch 'algo_main' of https://github.com/MonsileI/Algo_Study.git
	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
<<<<<<< HEAD
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
=======
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
>>>>>>> branch 'algo_main' of https://github.com/MonsileI/Algo_Study.git
		
<<<<<<< HEAD
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
=======
		int [] arr = new int [N];
		
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		
		int first = 0;
		int second = 0;
		
		int left = 0;
		int right = N-1;
		int min = Integer.MAX_VALUE;
		
		while(left<right) {
			
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < min) {
				first = left;
				second = right;
				min = Math.abs(sum);
>>>>>>> branch 'algo_main' of https://github.com/MonsileI/Algo_Study.git
			}
				
			else {
				if(sum>0) right--;
				else left++;
			}
		
		}
		
		
<<<<<<< HEAD
		int answer = 0;
		
		outerLoop:
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(i==j) continue;
				if(!arr[i][j] && !arr[j][i]) continue outerLoop; 
			}
			answer++;
		}
=======
>>>>>>> branch 'algo_main' of https://github.com/MonsileI/Algo_Study.git
		
<<<<<<< HEAD
		
		System.out.println(answer);
=======
		System.out.println(first +" "+ second);
>>>>>>> branch 'algo_main' of https://github.com/MonsileI/Algo_Study.git
	}
}
