package Algorithm_fifth_week_2023_07.bj;

import java.io.*;
import java.util.*;

public class bj_2589_보물섬_Gold_5 {
    static int N,M;
    static char[][]map;
    static int answer;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='L'){
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
    static void bfs(int y,int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x,0});
        boolean[][]visited = new boolean[N][M];
        visited[y][x] = true;
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            answer = Math.max(answer,cnt);
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]=='L') {
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj, cnt + 1});
                }
            }
        }
    }
}
