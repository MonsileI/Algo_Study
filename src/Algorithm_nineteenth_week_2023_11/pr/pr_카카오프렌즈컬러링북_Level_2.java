package Algorithm_nineteenth_week_2023_11.pr;

import java.util.*;

public class pr_카카오프렌즈컬러링북_Level_2 {

    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    static int[][]map;
    static int N,M;
    static int[] solution(int m, int n, int[][] picture) {
        N = picture.length; M = picture[0].length;
        map = picture;
        visited = new boolean[N][M];
        int []answer = new int[2];
        int max = 0 ;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&map[i][j]!=0){
                    answer[0]++;
                    int num = bfs(i,j,map[i][j]);
                    if(max<num){
                        max = num;
                        answer[1] = num;
                    }
                }
            }
        }
        return answer;
    }
    static int bfs(int y,int x,int shape){
        int cnt = 1;
        Queue<int[]> q= new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==shape){
                    visited[ni][nj] = true;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int m = 6; int n  =4;
        int[][]pictures = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution(m,n,pictures)));
    }
}
