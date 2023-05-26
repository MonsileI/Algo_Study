package May_third;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class bj_14502_연구소_Gold_4 {
    static int size,N,M,map[][],tmp[];
    static int answer = 0;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tmp = new int[3];
        int virusCnt = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) list.add(new int[]{i,j});
                if(map[i][j]==2) virusCnt++;
            }
        }

        size = list.size();

        comb(0,0);

        System.out.println(answer);

    }

    static void calc(){

        int[][]tmpMap = new int[N][M];

        Queue<int[]> q= new ArrayDeque<>();

        boolean[][]visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tmpMap[i][j] = map[i][j];
                if(tmpMap[i][j]==2) {q.offer(new int[]{i,j}); visited[i][j] = true;};
            }
        }

        for(int i=0;i<3;i++) tmpMap[list.get(tmp[i])[0]][list.get(tmp[i])[1]] = 1;


        while(!q.isEmpty()){

            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];

            for(int d=0;d<4;d++){

                int ni = i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(tmpMap[ni][nj]!=1 && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    tmpMap[ni][nj] = 2;
                    q.offer(new int[]{ni,nj});
                }
            }
        }

        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j>M;j++){
                if(tmpMap[i][j]==0) sum++;
            }
        }
        answer = Math.max(answer,sum);
    }

    static void comb(int start,int depth){

        if(depth==3){
            calc();
            return;
        }

        for(int i=start;i<size;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
