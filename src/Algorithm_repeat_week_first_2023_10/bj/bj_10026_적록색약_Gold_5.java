package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_10026_적록색약_Gold_5 {

    static boolean[][]visited;
    static int N;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][]map = new char[N][N];
        char[][]map2 = new char[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map2[i][j] = map[i][j] = str.charAt(j);
                if(map[i][j]=='G') map2[i][j] = 'R';
            }
        }
        int fir = calc(map);
        int sec = calc(map2);
        System.out.println(fir+ " "+sec);
    }
    static void bfs(int y,int x,char ch,char[][]map){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i +move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==ch){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
    static int calc(char[][]map){

        int cnt = 0;

        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    cnt++;
                    bfs(i,j,map[i][j],map);
                }
            }
        }
        return cnt;



    }
}
