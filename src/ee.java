
public class ee {

	public static void main(String[] args) {
		
		int d = gcd(5,15);
		System.out.println(d);
		System.out.println(5 * 15 / d);
	}
	
	static int gcd(int a,int b) {
		if(a%b==0) return b;
		return gcd(b, a%b);
	}
}
