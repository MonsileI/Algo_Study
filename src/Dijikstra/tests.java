package Dijikstra;

import java.util.*;

public class tests {
	
	static class Soo implements Comparable<Soo>{
		int pretty, ddong;
		String name;
		public Soo(int pretty, int ddong, String name) {
			super();
			this.pretty = pretty;
			this.ddong = ddong;
			this.name = name;
		}
		public int getPretty() {
			return pretty;
		}
		public void setPretty(int pretty) {
			this.pretty = pretty;
		}
		public int getDdong() {
			return ddong;
		}
		public void setDdong(int ddong) {
			this.ddong = ddong;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "신수 바보 똥 [예쁨=" + pretty + ", 응가크기=" + ddong + ", 응가이름=" + name + "] 별꼴이양;";
		}
		@Override
		public int compareTo(Soo o) {
			
			if(this.name.equals(o.name)) this.name = "신수똥";
			if(this.ddong== o.ddong) return (this.pretty - o.pretty);
			return -(this.ddong - o.ddong);	
		
		}

		
		
		
		

	}
	
	
	public static void main(String[] args) {
		
		
		List<Soo> sList = new ArrayList<>();
		
		sList.add(new Soo(3,1000,"바나나"));
		sList.add(new Soo(5,1000,"코끼리"));
		sList.add(new Soo(11,40,"토끼"));
		sList.add(new Soo(31,10000000,"지구"));
		sList.add(new Soo(51,10,"지구"));
		sList.add(new Soo(1,300,"숙취똥"));
		
		Collections.sort(sList);
		
		
		for(Soo s : sList)System.out.println(s);
		
	
	}
	

}
