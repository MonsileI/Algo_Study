package March_Second;

import java.util.*;
import java.io.*;
public class bj_17244_아맞다우산_Gold_2 {
    static int N,M,ni,nj,ei,ej;
    static int ot;
    static char[][]map;
    static boolean[][]visited;
    static List<int[]>object;
    static int[]tmp;
    static boolean[] dfsVisited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;


    public static void main(String[] args) throws Exception {
        answer = 987654321;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        object = new ArrayList<>();
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] =str.charAt(j);
                if(map[i][j]=='S') {
                    ni = i;
                    nj = j;
                }
                if(map[i][j]=='X') {
                    object.add(new int[]{i, j});
                    ot++;
                }
                if(map[i][j]=='E') {
                    ei = i;
                    ej = j;
                }
            }
        }

        tmp = new int[ot];
        dfsVisited = new boolean[ot];

        dfs(0);

        System.out.println(answer);
    }
    static int bfs(int gi,int gj){
        //도착하는곳이 order


        int y = ni;
        int x = nj;

        Queue<int[]> q= new ArrayDeque<>();

        q.offer(new int[]{y,x,0});

        while(!q.isEmpty()){

            int []c = q.poll();
            int i = c[0];
            int j = c[1];
            int cnt = c[2];

            if(i==gi && j==gj){
                ni = gi; nj = gi;
                return cnt;
            }

            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(!visited[ni][nj] && map[ni][nj]!='#'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        return 987654321;
    }


    static void calc(){

        int sum = 0;

        for(int i=0;i<ot;i++){
            visited = new boolean[N][M];
            int gi = object.get(tmp[i])[0];
            int gj = object.get(tmp[i])[1];
            sum += bfs(gi,gj);
        }


        sum += bfs(ei,ej);
        answer = Math.min(answer,sum);


    }

    static void dfs(int depth){

        if(depth==ot){
            calc();
            return;
        }

        for(int i=0;i<ot;i++){
            if(!dfsVisited[i]){
                dfsVisited[i] = true;
                tmp[depth] = i;
                dfs(depth+1);
                dfsVisited[i] = false;
            }
        }

    }
}
