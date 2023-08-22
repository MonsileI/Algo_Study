package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_28471_W키가빠진성원이_Silver_1 {
    static int N;
    static char[][]map;
    static int si,sj;
    static int answer;

    static int[][]move = {{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=str.charAt(j);
                if(map[i][j]=='F'){
                    si = i; sj = j;
                }
            }
        }
        bfs();
        System.out.println(answer);
    }
    static void bfs(){
        boolean[][]visited = new boolean[N][N];
        visited[si][sj] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj});

        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<7;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]=='.'){
                    answer++;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }


    }
}
