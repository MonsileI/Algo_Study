package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_16929_TowDots_Gold_4 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        String answer = "No";
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]) {
                    if (bfs(i, j, map[i][j])) {
                        answer = "Yes";
                        break OuterLoop;
                    }
                }
            }
        }
        System.out.println(answer);
    }
    static boolean bfs(int y,int x,char dot) {
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0];
            int j = c[1];


            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(ni==y&&nj==x) return true;
                if(!visited[ni][nj]&&map[ni][nj]==dot){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }

        }
        return false;
    }
}

