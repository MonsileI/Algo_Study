package August_second;

import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {
		
		int[][]arr =  new int[10][2];
		
		for(int i=1;i<10;i++) {
			arr[i][0] = i;
		}
		arr[1][1] = 10;

		Arrays.sort(arr, (o1,  o2)->{ 
				if(o1[1]==o2[1]) return o2[0]-o1[0];
				return  o2[1] - o1[1];
			}
		);
			
		
		System.out.println(Arrays.deepToString(arr));
		
	}

}
