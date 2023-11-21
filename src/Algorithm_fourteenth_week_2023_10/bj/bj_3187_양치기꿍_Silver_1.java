package Algorithm_fourteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_3187_양치기꿍_Silver_1 {
    static int N,M;
    static char[][]map;
    static int v,k;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if((map[i][j]=='v'||map[i][j]=='k')&&!visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        System.out.println(k+" "+v);
    }
    static void bfs(int y, int x){
        visited[y][x] = true;
        int sheap = map[y][x] =='k' ? 1 : 0;
        int wolf = map[y][x] =='v' ? 1 : 0;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!='#'){
                    visited[ni][nj] = true;
                    if(map[ni][nj]=='k') sheap++;
                    else if(map[ni][nj]=='v') wolf++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        if(wolf<sheap) k += sheap;
        else v += wolf;
    }
}
