package September_fourth;

public class test {

	public static void main(String[] args) {
		
		String s= "pPooloyY";
		s = s.toLowerCase();
		s = s.replaceAll("[^py]", "");
		
		int sum = 0;
		
		for(char ch : s.toCharArray()) {
			if(ch=='p') sum++;
			else sum--;
		}
		
		boolean answer = false;
		
		if(sum==0) answer = true;
		
		System.out.println(answer);
	}
}
