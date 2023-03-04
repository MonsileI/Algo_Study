package Febrary_third;

import java.util.*;
import java.io.*;
public class pr_무인도여행_Level_2 {

    static int N,M,map[][];
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    static int bfs(int y,int x){

        Queue<int[]> q= new ArrayDeque<>();

        visited[y][x] = true;

        int cnt = map[y][x];

        q.offer(new int[]{y,x});

        while(!q.isEmpty()){

            int[]c = q.poll();
            int i = c[0];
            int j = c[1];

            for(int d=0;d<4;d++){

                int ni = i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(!visited[ni][nj] && map[ni][nj]!=0){
                    visited[ni][nj] = true;
                    cnt += map[ni][nj];
                    q.offer(new int[]{ni,nj});
                }
            }


        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {

        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i].charAt(j)=='X') map[i][j] = 0;
                else map[i][j] = Integer.parseInt(maps[i].charAt(j)+"");
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=0 && !visited[i][j]){
                    int cnt = bfs(i,j);
                    list.add(cnt);
                }
            }
        }

        if(list.size()==0) System.out.println(-1);
        else{
            int[] answer = new int[list.size()];
            for(int i=0;i<list.size();i++) answer[i] = list.get(i);
            Arrays.sort(answer);
            for(int i : answer) System.out.println(i);
        }
    }
}
