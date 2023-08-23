package Algorithm_eighth_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_영상처리_Level_3 {
    static int N,M;
    static char[][]map;
    static int cnt,maxValue;
    static boolean[][]visited;
    static int[][]move= {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&map[i][j]=='#'){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxValue);
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        int sum = 1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==map[y][x]){
                    visited[ni][nj] = true;
                    sum++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        maxValue = Math.max(maxValue,sum);
    }
}
