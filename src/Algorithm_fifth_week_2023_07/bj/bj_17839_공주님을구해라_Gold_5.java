package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_17839_공주님을구해라_Gold_5 {
    static int N,M,T;
    static int[][]map;
    static boolean[][][]visited;
    static int[][]move= {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean flag;


    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        flag = false;
        bfs();
        if(!flag || T < answer) System.out.println("Fail");
        else System.out.println(answer);
    }
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0];
            int j = c[1];
            int cnt = c[2];
            int key = c[3];
            if(i==N-1&&j==M-1){
                answer = cnt;
                flag= true;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(key==0){
                    if(!visited[ni][nj][0]){

                       if(map[ni][nj]==0) {
                           visited[ni][nj][0] = true;
                           q.offer(new int[]{ni,nj,cnt+1,0});
                       } else if(map[ni][nj]==2) {
                           visited[ni][nj][0] = true;
                           q.offer(new int[]{ni,nj,cnt+1,1});
                       }
                    }
                }else{
                    if(!visited[ni][nj][1]) {
                        visited[ni][nj][0] = true;
                        q.offer(new int[]{ni,nj,cnt+1,1});
                    }
                }

            }

        }
    }
}
