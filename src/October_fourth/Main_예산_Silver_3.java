package October_fourth;

import java.util.*;
import java.io.*;

public class Main_예산_Silver_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[]arr = new int[N];
		
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());	
		
		int money = Integer.parseInt(br.readLine());
		int tmp = money;
		int answer = 0;
		
		Arrays.sort(arr);
		int i;
		
		for(i=0;i<N;i++) {
			if(tmp-arr[N] <0 ) {
				break;
			}
			tmp -= arr[N];	
		}
		
		
	}
}
