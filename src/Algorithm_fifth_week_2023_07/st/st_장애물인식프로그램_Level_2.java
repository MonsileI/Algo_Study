package Algorithm_fifth_week_2023_07.st;

import java.util.*;
import java.io.*;
public class st_장애물인식프로그램_Level_2 {
    static int N,map[][];
    static List<Integer> list;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]&&map[i][j]==1){
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int N = list.size();
        sb.append(N).append("\n");
        for(int num : list) sb.append(num).append("\n");
        System.out.println(sb.toString());
    }

    static int bfs(int y,int x){
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        int cnt = 1;
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0];
            int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==1){
                    visited[ni][nj] = true;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }
}
