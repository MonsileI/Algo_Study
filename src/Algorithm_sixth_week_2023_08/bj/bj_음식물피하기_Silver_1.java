package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;

public class bj_음식물피하기_Silver_1 {
    static int N,M;
    static int map[][];
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int answer = 0;
        for(int r =0;r<R;r++){
            st = new StringTokenizer(br.readLine()," ");
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1&&!visited[i][j]){
                    visited[i][j] = true;
                    answer = Math.max(answer,bfs(i,j));
                }
            }
        }

        System.out.println(answer);

    }
    static int bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        int cnt = 1;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj= j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==1){
                    visited[ni][nj] = true;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }
}
