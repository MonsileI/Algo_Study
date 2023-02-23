package Febrary_third;

import java.util.*;
import java.io.*;
public class pr_미로탈출_Level_2 {

    static int answer, N, M, map[][];
    static boolean[][] visited;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static void bfs(int[] start,int goal) {

        visited = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{start[0], start[1], 0});

        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {

            int[] c = q.poll();

            int i = c[0];
            int j = c[1];
            int cnt = c[2];

            if (map[i][j] == goal) {
                answer += cnt;
                return;
            }

            for(int d=0;d<4;d++){
                int ni= i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj] != 1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }

        answer = 0;
    }

    public static void main(String[] args) throws Exception {
        String[] maps = {"XXXXL", "XOOSX", "XXXXX", "XXXOO", "EXXXX", "XXXXX"   };
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        int[] start = new int[2];
        int[] lever = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'S') {
                    map[i][j] = 5;
                    start[0] = i;
                    start[1] = j;//시작
                }else if (maps[i].charAt(j) == 'O') map[i][j] = 0; //가도됨
                else if (maps[i].charAt(j) == 'X') map[i][j] = 1; //못감
                else if (maps[i].charAt(j) == 'L') {
                        map[i][j] = 2;
                        lever[0] = i;
                        lever[1] = j;
                        //레버
                }else if (maps[i].charAt(j) == 'E') map[i][j] = 3; //출구
                }
            }
            answer = 0;
            bfs(start,2);

            if(answer==0) answer  = -1;
            else bfs(lever,3);
            if(answer==0) answer = -1;
            System.out.println(answer);
        }
    }


