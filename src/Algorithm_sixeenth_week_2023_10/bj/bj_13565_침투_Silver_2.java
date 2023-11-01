package Algorithm_sixeenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_13565_침투_Silver_2 {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static boolean flag;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        visited = new boolean[N][M];
        for(int j=0;j<M;j++){
            if(flag) break;
            if(!visited[0][j]&&map[0][j]==0){
                bfs(j);
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
    static void bfs(int index){
        Queue<int[]> q =new ArrayDeque<>();
        visited[0][index] = true;
        q.offer(new int[]{0,index});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            if(i==N-1){
                flag= true;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==0){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
