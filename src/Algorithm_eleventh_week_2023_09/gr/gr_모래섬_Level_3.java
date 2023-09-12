package Algorithm_eleventh_week_2023_09.gr;

import java.util.*;
import java.io.*;
public class gr_모래섬_Level_3 {
    static int N,M,map[][];
    static Queue<int[]> q;
    static boolean [][]visited;
    static boolean check;

    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        q = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) q.offer(new int[]{i,j});
            }
        }
        int answer = 0;
        while(true){
            if(check()) break;
            bfs();
            if(check) break;
            answer++;
        }
        if(check) answer = -1;
        System.out.println(answer);
    }
    static void bfs2(int y,int x){
        Queue<int[]> q2 = new ArrayDeque<>();
        q2.offer(new int[]{y,x});
        while(!q2.isEmpty()){
            int[]c = q2.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==1&&!visited[ni][nj]){
                    visited[ni][nj] = true;
                    q2.offer(new int[]{ni,nj});
                }
            }
        }

    }
    static boolean check(){

        //한덩어리면 return false;
        boolean flag = true;
        visited=  new boolean[N][M];


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1&&!visited[i][j]){
                    if(!flag) return true;
                    flag = false;
                    visited[i][j] = true;
                    bfs2(i,j);

                }
            }
        }
        if(flag) check = true;
        return false;
    }
    static void bfs(){
        int size = q.size();
        for(int t =0;t<size;t++){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==1){
                    map[ni][nj] = 0;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
