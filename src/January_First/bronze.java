package January_First;

public class bronze {
	
	public static void main(String[] args) {
	
		String str = "123abcABC";
		
		//0->0
		//1->9
		//2->8
		//3->7
		//4->6
		//5->5
		
		String answer = "";
		
		for(int i=0;i<str.length();i++) {
			
			char ch = str.charAt(i);
			
			if('0'<=ch && ch <= '9') {
				int tmp = Integer.parseInt(ch+"");
				tmp = Math.abs(tmp-10);
				answer += tmp;
			}else {
				if('a'<=ch && ch <= 'z') ch--;
				else ch++;
					
				answer += ch;
			}
			
		}
		
		System.out.println(answer);
	}

}
