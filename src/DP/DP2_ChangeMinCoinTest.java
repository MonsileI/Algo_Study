package DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest {

	//1 4 6원 화폐단위 고정, 동전 개수 무제한
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		
		int[] D = new int[money+1];
		
		D[0] = 0; //0원에 대한 최적해는 0
		int INF = Integer.MAX_VALUE;
		for(int i=1;i<=money;i++) {
			int min = INF;
			min = Math.min(min, D[i-1]+1); //+1 -> 1원에 대한 최적해는 1
			if(i>=4) min = Math.min(min, D[i-4]+1);
			if(i>=6) min = Math.min(min, D[i-6]+1);
			D[i] = min;
		}
		
		
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
		
		
	}
}
