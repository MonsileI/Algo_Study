package Algorithm_twenty_week_2023_12.pr;
import java.util.*;
public class pr_석유시추_Level_2 {

    static int[][]map;
    static int N,M;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int solution(int[][] land) {
        map = land;
        int answer = 0;
        N = land.length;
        M = land[0].length;
        for(int j=0;j<M;j++){
           int sum = 0;
           visited=  new boolean[N][M];
           for(int i=0;i<N;i++){
               if(land[i][j]==1&&!visited[i][j]){
                    sum += bfs(i,j);
               }
           }
           answer = Math.max(answer,sum);
        }

        return answer;
    }
    static int bfs(int y,int x){
        int cnt = 1;
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]==1){
                    cnt++;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][]land = {{1, 0, 1, 0, 1, 1},{1, 0, 1, 0, 0, 0},{1, 0, 1, 0, 0, 1},{1, 0, 0, 1, 0, 0},{1, 0, 0, 1, 0, 1},{1, 0, 0, 0, 0, 0},{1, 1, 1, 1, 1, 1}};
        System.out.println(solution(land));
    }
}
