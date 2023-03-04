package March_first;

import java.util.*;
import java.io.*;
public class bj_2583_영역구하기_Silver_1 {

    static int map[][],N,M,C,cnt;
    static boolean[][]visited;
    static List<Integer> list = new ArrayList<>();

    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    static void bfs(int y,int x){

        cnt++;

        Queue<int[]> q = new ArrayDeque<>();

        visited[y][x] = true;

        q.offer(new int[]{y,x});

        while(!q.isEmpty()){

            int [] c=  q.poll();
            int i = c[0];
            int j = c[1];

            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(!visited[ni][nj] && map[ni][nj]==0){
                    visited[ni][nj] = true;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }

        list.add(cnt);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        5 7 3
        0 2 4 4
        1 1 2 5
        4 0 6 2
        * */
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int d=0;d<C;d++){
            st = new StringTokenizer(br.readLine()," ");
            int fj = Integer.parseInt(st.nextToken());
            int fi = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken())-1;
            int si = Integer.parseInt(st.nextToken())-1;

            for(int i=fi;i<=si;i++){
                for(int j=fj;j<=sj;j++){
                    map[i][j] = 1;
                }
            }
        }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==0 && !visited[i][j]){
                        cnt = 0;
                        bfs(i,j);
                    }
                }
            }

            Collections.sort(list);
            System.out.println(list.size());
            for(int a : list) System.out.print(a+" ");

    }
}
