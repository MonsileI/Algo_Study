package December_fourth;


public class Random {
	
	public static void main(String[] args) {
		
		String[]names = {"이유경","김태원","박민지",
						 "이지원","정상기","정지은",
						 "이상원","이승헌","배연주","이윤석"};
		int[]nums = new int[10];
						
		for(int i=0;i<10;i++) {
			nums[i] = (int)(Math.random()*10);
			for(int j=0;j<i;j++) {
				if(nums[i]==nums[j]) { i--; break; }
			}
		}
		int idx = 1;
		System.out.println(idx++ +". "+"박한샘");
		for(int i : nums) System.out.println(idx++ +". "+names[i]);
		
	}

}
