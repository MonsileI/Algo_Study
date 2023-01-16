package January_third;

import java.io.*;
import java.util.*;
public class bj_2638_치즈_Gold_3 {

    static int N,M,map[][];
    static boolean[][]visited;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int cheeze = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) cheeze++;
            }
        }

        int time = 0;

        while(true){
            time++;

            visited = new boolean[N][M];

            visited[0][0] = true;

            bfs();

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==2){
                        int check =0;
                        for(int d=0;d<4;d++){
                            int ni = i + move[d][0];
                            int nj = j + move[d][1];
                            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                            if(visited[ni][nj]) check++;
                            if(1<check) {
                                map[i][j] = 0;
                                cheeze--;
                                break;
                            }
                        }
                    }
                }
            }

            if(cheeze==0) break;
        }
        System.out.println(time);
    }

    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0,0});

        while(!q.isEmpty()){

            int [] c = q.poll();
            int i = c[0];
            int j = c[1];

            for(int d=0; d<4;d++){

                int ni = i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(visited[ni][nj]) continue;

                if(map[ni][nj]==1){
                    map[ni][nj]=2;
                }
                if(map[ni][nj]==0){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }

            }
        }

    }
}
