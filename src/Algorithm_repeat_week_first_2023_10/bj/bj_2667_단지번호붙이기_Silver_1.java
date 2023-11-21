package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2667_단지번호붙이기_Silver_1 {
    static int N;
    static int[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
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
        int ans = list.size();
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(ans+"\n");
        for(int i : list) sb.append(i+"\n");
        System.out.println(sb.toString());
    }
    static int bfs(int y,int x){
        int cnt = 1;
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1];
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
