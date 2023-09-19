package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_11123_양한마리양두마리_Silver_2 {
    static int N,M;
    static boolean[][]visited;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =null;
        for(int t=0;t<TC;t++){
            st =new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];
            int cnt = 0;
            for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j]&&map[i][j]=='#'){
                        cnt++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int y,int x){

        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i =c[0]; int j=c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&& map[ni][nj]=='#'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }




    }
}
