package Algorithm_second_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_14940_쉬운최단거리_SIlver_1 {
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M,map[][];
    static int answer[][];
    static boolean[][]visited;
    static int si,sj;
    public static void main(String[] args) throws Exception {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    si = i; sj = j;
                    answer[i][j] = 0;
                }else if(map[i][j]==0) {
                    visited[i][j] = true;
                    answer[i][j] = 0;
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]) sb.append(-1+" ");
                else sb.append(answer[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si,sj,1});
        visited[si][sj] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int cnt = c[2];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(answer[ni][nj]==0&&map[ni][nj]==1){
                    answer[ni][nj] = cnt;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
    }
}
