package Algorithm_sixteenth_week_2023_10.gr;
import java.util.*;
import java.io.*;
public class gr_발전기2_Level_2 {
    static int N,K,map[][];
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[]dist = new int[31];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    int sum= bfs(i,j,map[i][j]);
                    if(sum<K) continue;
                    dist[map[i][j]]++;
                }
            }
        }
        int max = 0;
        int ans = 0;
        for(int i = 0; i < 31 ;i++){
            if(max<=dist[i]){
                max = dist[i];
                ans = i;
            }
        }
        System.out.println(ans);
    }
    static int bfs(int y,int x,int v){
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        int sum = 1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&& map[ni][nj]==v){
                    sum++;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return sum;
    }
}
