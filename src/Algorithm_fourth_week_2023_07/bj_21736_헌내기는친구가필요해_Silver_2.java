package Algorithm_fourth_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_21736_헌내기는친구가필요해_Silver_2 {
    static int N,M;
    static char[][]map;
    static int si,sj,answer;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='I') {si = i; sj = j;}
            }
        }
        bfs();
        System.out.println(answer==0 ? "TT" : answer);
    }
    static void bfs(){
        answer = 0;
        visited[si][sj] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si,sj});
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]!='X'&&!visited[ni][nj]){
                    if(map[ni][nj]=='P') answer++;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
