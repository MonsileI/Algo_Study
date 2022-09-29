package DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest2 {

	// 4 6원 화폐단위 고정, 동전 개수 무제한
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		
		int[] D = new int[money+1];
		
		D[0] = 0; //0원에 대한 최적해는 0
		int INF = money; //가장 작은 화폐단위를 가장 많이 써도 만들 수 없는 큰 값, +1 처리시 오버플로우 조심
		for(int i=1;i<=money;i++) {
			int min = INF;
			if(i>=4) min = Math.min(min, D[i-4]+1);
			if(i>=6) min = Math.min(min, D[i-6]+1);
			D[i] = min;
		}
		
		
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
		System.out.println(D[money]==INF ? -1 : D[money]);
		
		
	}
}
