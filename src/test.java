
import java.io.*;
import java.util.*;
//N개의 자연수 중에서 M개를 고른 수열
//고른 수열은 오름차순
//첫째 줄에 N과 M이(1 ≤ M ≤ N ≤ 8)
//둘째 줄에 N개의 수. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력
//각 수열은 공백으로 구분해서 출력
//수열은 사전 순으로 증가하는 순서로 출력
/*
4 2
9 8 7 1
*/
public class test {

	static int N;
	static int M;
	static int[] arr;
	static int[] answer;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static List<String> list = new ArrayList<>();
	public static void main(String args[])throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permu(0, "");
		System.out.println(sb.toString());
	}
	static void permu(int dep, String str) {
		if(dep == M) {
			if(!list.contains(str)) {
				list.add(str);
				for(int i = 0; i < M; i++) {
					sb.append(answer[i]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[dep] = arr[i];
				permu(dep + 1, str + arr[i]);
				visited[i] = false;
			}
		}
	}

}
