package September_first;
import java.util.*;
import java.io.*;
public class bj_1253_좋다_Gold_4 {

	static int N;
	static int[]arr;
	static int answer;
	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());;
		
		for(int i=0;i<N;i++)  arr[i] = Integer.parseInt(st.nextToken());
		
	}
	static void output() {
		System.out.println(answer);
	}
	
	static void calc() {
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		int maxValue = arr[end];
		
		while(start<end) {
			
			int sum = arr[start] + arr[end];
			
			
			if(sum>maxValue) {
				end--;
			}else if(sum==maxValue) {
				answer += 2;
				maxValue = arr[--end];
				
			}else {
				start++;
			}
			
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		input();
		calc();
		output();
	}
}
