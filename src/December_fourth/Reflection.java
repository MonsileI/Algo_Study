package December_fourth;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflection {
	
	public static void main(String[] args) throws Exception {

//		Naruto n = new Naruto();
//		System.out.println(n.Sasuke);
//		n.나선환();
		
		Class<?> cl = Class.forName("December_fourth.Naruto");
		Method[]m = cl.getMethods();
		System.out.println(m[0]);
		System.out.println(m[1]);
		
		
	}
}

