package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_11559_PuyoPuyo_Gold_4 {
    static char[][] map;
    static int N,M;
    static boolean flag;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        N = 12; M = 6;
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        int time = 0;
        while(true){
            flag = false;
            calc();
            if(!flag) break;
            gravity();
            time++;
        }
        System.out.println(time);
    }

    static void gravity(){



        for(int i=N-1;-1<i;i--){
            for(int j=0;j<M;j++){
                if(map[i][j]!='.'){
                    while(true){
                        int ni = i + 1;
                        if(N-1<ni) break;
                        if(map[ni][j]=='.'){
                            map[ni][j] = map[i][j];
                            map[i][j] = '.';
                            i = ni;
                        }else break;
                    }
                }
            }
        }

    }

    static void calc(){
        visited= new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!='.'&&!visited[i][j]){
                    bfs(i,j);
                }
            }
        }
    }
    static void bfs(int y,int x){

        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 1;
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        List<int[]> list = new ArrayList<>();
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j= c[1];
            for(int d=0;d<4;d++){
                int ni  = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[y][x]==map[ni][nj]){
                    visited[ni][nj] = true;
                    list.add(new int[]{ni,nj});
                    q.offer(new int[]{ni,nj});
                    cnt++;
                }
            }
        }
        if(3<cnt){
            list.add(new int[]{y,x});
            for(int i=0;i<list.size();i++){
                map[list.get(i)[0]][list.get(i)[1]] = '.';
            }
            flag = true;
        }


    }
}
