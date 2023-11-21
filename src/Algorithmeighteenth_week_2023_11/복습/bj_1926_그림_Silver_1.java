package Algorithmeighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_1926_그림_Silver_1 {

    static int N,M,map[][];
    static boolean[][]visited;
    static int ans;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int cnt = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1&&!visited[i][j]){
                    visited[i][j] = true;
                    cnt++;
                    ans = Math.max(ans,bfs(i,j));
                }
            }
        }
        System.out.println(cnt);
        System.out.println(ans);
    }
    static int bfs(int y,int x){
        int tmp = 1;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==1){
                    visited[ni][nj] = true;
                    tmp++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return tmp;
    }
}
