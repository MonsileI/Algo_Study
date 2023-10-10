package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2468_안정영역_Silver_1 {
    static int N;
    static int[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        max--;
        int ans = 0;
        while (-1 < max) {
            visited = new boolean[N][N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] & max < map[i][j]) {
                        bfs(i, j, max);
                        sum++;
                    }
                }
            }
            ans = Math.max(ans, sum);
            max--;
        }
        System.out.println(ans);
    }
    static void  bfs(int y,int x,int max){
        Queue<int[]> q=  new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i +move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&max<map[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
