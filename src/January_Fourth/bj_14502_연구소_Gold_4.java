package January_Fourth;
import java.util.*;
import java.io.*;

public class bj_14502_연구소_Gold_4 {
    static int N,M,map[][],answer,tmpMap[][];
    static List<int[]> wallList;
    static int size;
    static int []tmp = new int[3];
    static boolean[][]visited;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        wallList = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) wallList.add(new int[]{i,j});

            }
        }
        answer = 0;
        size = wallList.size();


        //벽을 세우자
        comb(0,0);


        System.out.println(answer);




    }
    static void bfs(int y,int x){

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{y,x});

        visited[y][x] = true;

        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0];
            int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(!visited[ni][nj] && tmpMap[ni][nj]!=1){
                    visited[ni][nj] = true;
                    tmpMap[ni][nj] = 2;
                    q.offer(new int[]{ni,nj});
                }

            }

        }


    }
    static void calc(){

        tmpMap = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tmpMap[i][j] = map[i][j];
            }
        }

        for(int c=0;c<3;c++){
            int[]t = wallList.get(tmp[c]);
            tmpMap[t[0]][t[1]] = 1;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tmpMap[i][j]==2 && !visited[i][j]) bfs(i,j);
            }
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tmpMap[i][j]==0) cnt++;
            }
        }

        answer = Math.max(answer,cnt);

    }

    static void comb(int depth, int start){

        if(depth==3){
            calc();

            return;
        }

        for(int i=start;i<size;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }
}
