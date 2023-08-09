package Algorithm_sixth_week_2023_08.pr;

import java.util.*;

public class pr_카카오프렌즈컬러링북_Level_2 {
    static int M,N,map[][];
    static int answer[];
    static boolean[][]visited;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int m = 6; int n =4;
        N = m; M = n;
        int[][]picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        map = picture;
        visited = new boolean[N][M];
        answer = new int[2];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&map[i][j]!=0){
                    visited[i][j] = true;
                    answer[0]++;
                    answer[1] = Math.max(answer[1],bfs(i,j,map[i][j]));
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
    static int bfs(int y,int x,int s){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        int cnt = 1;
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0];
            int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==s){
                    visited[ni][nj] = true;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }
}
