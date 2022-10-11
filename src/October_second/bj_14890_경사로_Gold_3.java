package October_second;

import java.util.*;

import java.io.*;

public class bj_14890_경사로_Gold_3 {

	static int N , X , map[][], map2[][];
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		map2 = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int answer = process();
		System.out.println(answer);
		
	
		
	}
	static int process() {
		int count = 0;
		for(int i=0;i<N;i++) {
			if(makeRoad(map[i])) count++;
			if(makeRoad(map2[i])) count++;
		}
		return count;
		
	}
	// 해당 지형 정보로 활주로 건설이 가능하면 true, 아니면 false
	static boolean makeRoad(int[]road) {
		
		int beforeHeight = road[0],size = 0;
		int j = 0;
		
		while(j<N) {
			if(beforeHeight == road[j]) { //동일 높이
				size++;
				j++;
			
			}else if(beforeHeight+1 == road[j]) { //이전 높이보다 1높음 : 오르막 경사로 설치 체크
				if(size<X) return false; //x길이 미만이면 활주로 건설 불가
				
				beforeHeight++;
				size = 1;
				j++;
			}else if(beforeHeight-1 == road[j]) { //이전 높이보다 1 작음
				int count = 0;
				for(int k=j;k<N;k++) {
					if(road[k] != beforeHeight-1) return false;
					
					if(++count == X) break;
				}
				
				if(count < X) return false; // 끝까지 갔지만, 연속길이를 보장하지 못해서 내려온거니까 return
				
				beforeHeight--; //내리막 경사로로 높이가 줄어들었으니까 높이 줄이기
				j += X;
				size = 0;
				
				
			}else { //높이가 2이상 차이
				return false;
			}
		}
		
		return true;
	}

}
