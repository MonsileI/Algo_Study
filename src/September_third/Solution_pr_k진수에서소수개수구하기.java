package September_third;

public class Solution_pr_k진수에서소수개수구하기 {

	
	
	public static void main(String[] args) {
		
		//3진수에서 소수 구하기
		int n = 110011;
		int k = 10;
		int answer = 0;
		String num = "";
		
		while(n>0) {
			num = (n % k) + num;
			n /= k;
			
		}
	
		String check="";
		for(int i=0;i<num.length();i++) {
			if(num.charAt(i)=='0') {
				if(!check.isEmpty()) if(calc(check)) answer++;
				check="";
			}else check += num.charAt(i);
			
		}
		if(!check.isEmpty()) {
			if(calc(check))answer++;
		}
		
		System.out.println(answer);
	}
	static boolean calc(String num) {
		
		long no = Long.parseLong(num);
		if(no==1) return false;
		if(no==2) return true;
		for(int i=3;i<=Math.sqrt(no);i++) if(no%i==0) return false;
		
		
		return true;
	}
}
