package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1303_전쟁_전투_Silver_1 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int t,a;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());  N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    if(map[i][j]=='W') t += bfs(i,j,map[i][j]);
                    else a += bfs(i,j,map[i][j]);
                }
            }
        }
        System.out.println(t+" "+a);
    }

    static int bfs(int y,int x,char ch){
        visited[y][x] = true;
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj)  continue;

                if(!visited[ni][nj]&&map[ni][nj]==ch){
                    visited[ni][nj] = true;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt*cnt;
    }
}
