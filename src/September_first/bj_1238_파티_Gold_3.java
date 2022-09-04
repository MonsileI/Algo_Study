package September_first;

import java.util.*;
import java.io.*;

public class bj_1238_파티_Gold_3 {

	static class Node implements Comparable<Node>{
		
		int end,weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {	
			return weight - o.weight;
		}
		
		
		
	}
	static int N;
	static int M;
	static int X;
	static List<ArrayList<Node>> arrList, reverse_arrList;
	
	
	static void input() throws Exception{
		
	}
	public static void main(String[] args) throws Exception {
		input();
		
	}
}
