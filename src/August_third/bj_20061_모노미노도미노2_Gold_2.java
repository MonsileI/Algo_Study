package August_third;

import java.util.*;
import java.io.*;
/*
 초록색 6 by 4
 파란색 4 by 6
 
 초록색 한 j가 다 채워지면 그 칸 없애고 +1
 파란색 한 i가 다 채워지면 그 칸 없애고 +1

초록색 0이나 1값에 무슨 값이 들어오면 -> 그만큼 아래 행 제거
파란색 0이나 1값에 무슨 값이 들어오면 -> 그만큼 오른쪽 열 제거
 
t = 1: 크기가 1×1인 블록을 (x, y)에 놓은 경우
t = 2: 크기가 1×2인 블록을 (x, y), (x, y+1)에 놓은 경우 (ij로 바꾸면, i+1 , j)
t = 3: 크기가 2×1인 블록을 (x, y), (x+1, y)에 놓은 경우 (ij로 바꾸면, i , j+1)
 
  
 */



public class bj_20061_모노미노도미노2_Gold_2 {
	
	static int[][]green;
	static int score;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[10][10]; //다 합쳐진 형태 ( 블루 + 그린 )
		
		while (N > 0) {
			N--;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); //i좌표
			int x = Integer.parseInt(st.nextToken()); //j좌표

			
			move(t, y, x);
			
			
			calc();
			
			isCheck();
		}

		System.out.println(score);
		System.out.println(blockCnt());
	}

	public static void move(int t, int y, int x) {
		
		if (t == 1) { //블록 모양이 한개일 떄,
			
			//blue
			for (int i = x; i <= 8; ++i) {
				if (map[y][i + 1] == 1) { //다음값에 블록이 있음,
					map[y][i] = 1; //넣어준다.
					break;
				} else {
					//큰 맵을 그리는 형태, 바닥에 닿으면 1을 넣어준다.
					if (i == 8) {
						map[y][i + 1] = 1;
					}
				}
			}
			
			//Green
			for (int i = y; i <= 8; ++i) {
				if (map[i + 1][x] == 1) {
					map[i][x] = 1;
					break;
				} else {
					//바닥이면 블록
					if (i == 8) {
						map[i + 1][x] = 1;
					}
				}
			}
		} else if (t == 2) {  //가로로 긴 애! j가 길다
			//Blue
			for (int i = x; i <= 7; ++i) {
				if (map[y][i + 2] == 1) { //2전에 닿으면 걸러주려고
					map[y][i] = 1; map[y][i + 1] = 1;
					break;
				} else {
					//바닥이면 블록
					if (i == 7) {
						map[y][i + 2] = 1; map[y][i + 1] = 1;
					}
				}
			}
			//Green
			for (int i = y; i <= 8; ++i) {
										  //이런 경우, 걸쳐지는 경우가 생긴다. 걸쳐져도 위에 쌓아주기
				if (map[i + 1][x] == 1 || map[i + 1][x + 1] == 1) {
					map[i][x] = 1; map[i][x + 1] = 1;
					break;
				} else {
					//바닥이면 블록
					if (i == 8) {
						map[i + 1][x] = 1; map[i + 1][x + 1] = 1;
					}
				}
			}
		} else if (t == 3) { //세로로 긴 애! i가 길다
			//Blue
			for (int i = x; i <= 8; ++i) {
				if (map[y][i + 1] == 1 || map[y + 1][i + 1] == 1) {
					map[y][i] = 1; map[y + 1][i] = 1;
					break;
				} else {
					//바닥이면 블록
					if (i == 8) {
						map[y][i + 1] = 1; map[y + 1][i + 1] = 1;
					}
				}
			}
			//Green
			for (int i = y; i <= 7; ++i) {
				if (map[i + 2][x] == 1) {
					map[i][x] = 1; map[i + 1][x] = 1;
					break;
				} else {
					//바닥이면 블록
					if (i == 7) {
						map[i + 1][x] = 1; map[i + 2][x] = 1;
					}
				}
			}
		}
	}

	public static void calc() {
		
		int[] move = new int[11]; //move[i] = i(행/열)의 블록이 내려가야하는 이동횟수

		//Green 영역
		boolean	flag = false;

		for (int i = 9; i >= 6; --i) {
			int cnt = 0;

			for (int j = 0; j < 4; ++j) {
				if (map[i][j] == 1) cnt++;
				else break;
			}

			move[i] = move[i + 1];

			//만약 i번째 행의 블록이 꽉찼다면
			if (cnt == 4) {
				flag = true;
				score++;
				move[i]++; //i행 위로의 블록은 1칸 내려줘야함

				for (int j = 0; j < 4; ++j) {
					map[i][j] = 0;
				}
			}
		}

		move[4] = move[5] = move[6]; //연한 영역은 따로 이동횟수를 저장해줌

		if (flag) {
			for (int i = 8; i >= 4; --i) {
				if (move[i] == 0) continue;
				for (int j = 0; j < 4; ++j) {
					//i행에 블록이 존재하면 i+move[i]행만큼 이동
					if (map[i][j] == 1) {
						map[i + move[i]][j] = 1;
						map[i][j] = 0;
					}
				}
			}
		}

		Arrays.fill(move, 0);

		//Blue 영역
		flag = false;
		
		for (int j = 9; j >= 6; --j) {
			int cnt = 0;
			for (int i = 0; i < 4; ++i) {
				if (map[i][j] == 1) cnt++;
				else break;
			}
			move[j] = move[j + 1];

			//만약 j번째 열의 블록이 꽉찼다면
			if (cnt == 4) {
				flag = true;
				score++;
				move[j]++; //j열 위로의 블록은 1칸 내려줘야함

				for (int i = 0; i < 4; ++i) {
					map[i][j] = 0;
				}
			}
		}

		move[4] = move[5] = move[6]; //연한 영역은 따로 이동횟수를 저장해줌

		if (flag) {
			for (int j = 8; j >= 4; --j) {
				if (move[j] == 0) continue;
				for (int i = 0; i < 4; ++i) {
					//j열에 블록이 존재하면 j+move[j]열만큼 이동
					if (map[i][j] == 1) {
						map[i][j + move[j]] = 1;
						map[i][j] = 0;
					}
				}
			}
		}
	}

	public static void isCheck() {
		int cnt = 0;

		//연한 green 영영에 블록이 있는 행의 수를 구함
		for (int i = 4; i <= 5; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (map[i][j] == 1) {
					cnt++;
					break;
				}
			}
		}

		if (cnt > 0) {
			for (int i = 9; i >= 4; --i) {
				// 구한 행의 수만큼 블록을 제거해줌
				if (i > 9 - cnt) {
					for (int j = 0; j < 4; ++j) {
						map[i][j] = 0;
					}
				} 
				// 나머지 행의 블록들을 구한 행의 수만큼 이동
				else {
					for (int j = 0; j < 4; ++j) {
						if (map[i][j] == 1) {
							map[i + cnt][j] = 1;
							map[i][j] = 0;
						}
					}
				}
			}
		}

		cnt = 0;

		//연한 blue 영영에 블록이 있는 열의 수를 구함
		for (int j = 4; j <= 5; ++j) {
			for (int i = 0; i < 4; ++i) {
				if (map[i][j] == 1) {
					cnt++;
					break;
				}
			}
		}

		if (cnt > 0) {
			for (int j = 9; j >= 4; --j) {
				// 구한 열의 수만큼 블록을 제거해줌
				if (j > 9 - cnt) {
					for (int i = 0; i < 4; ++i) {
						map[i][j] = 0;
					}
				}
				// 나머지 열의 블록들을 구한 열의 수만큼 이동
				else {
					for (int i = 0; i < 4; ++i) {
						if (map[i][j] == 1) {
							map[i][j + cnt] = 1;
							map[i][j] = 0;
						}
					}
				}
			}
		}
	}

	public static int blockCnt() {
		int cnt = 0;
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}