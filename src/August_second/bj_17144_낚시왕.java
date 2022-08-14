package August_second;

import java.io.*;
import java.util.*;

public class bj_17144_낚시왕 {
	
	static int[][] shark;
	static int maxI;
	static int maxJ;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		maxI = Integer.parseInt(st.nextToken());
		maxJ = Integer.parseInt(st.nextToken());
	
		int sharks = Integer.parseInt(st.nextToken());
		
		shark = new int[sharks][6]; //죽었나 살았나도 넣어주자
		
		for(int i=0;i<sharks;i++) {
			st = new StringTokenizer(br.readLine()," ");
			shark[i][0] = Integer.parseInt(st.nextToken());
			shark[i][1] = Integer.parseInt(st.nextToken());
			shark[i][2] = Integer.parseInt(st.nextToken());
			shark[i][3] = Integer.parseInt(st.nextToken());
			shark[i][4] = Integer.parseInt(st.nextToken());
			shark[i][5] = 1; //살아있음
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}
