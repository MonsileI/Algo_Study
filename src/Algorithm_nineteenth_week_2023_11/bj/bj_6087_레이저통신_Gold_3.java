package Algorithm_nineteenth_week_2023_11.bj;

import java.util.*;
import java.io.*;
public class bj_6087_레이저통신_Gold_3 {
    static class Node implements Comparable<Node>{
        int i;int j; int turn;int dir;

        public Node(int i, int j, int turn,int dir) {
            this.i = i;
            this.j = j;
            this.turn = turn;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return turn - o.turn;
        }
    }
    static int N,M;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si = 0 ;int sj = 0;
        boolean flag = false;
        int[][]visited = new int[N][M];
        int INF = 987654321;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                visited[i][j] = INF;
                if(map[i][j]=='C'&&!flag){
                    si = i;
                    sj = j;
                    map[i][j] = '.';
                    flag = true;
                }
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(si,sj,0,5));
        visited[si][sj] = 0;
        int ans = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i; int j = now.j; int turn = now.turn; int dir = now.dir;
            if(map[i][j]=='C'){
                ans = turn;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='*') continue;
                    if(d==dir||dir==5){
                        if(visited[ni][nj] > turn){
                            visited[ni][nj] =turn;
                            pq.offer(new Node(ni,nj,turn,d));
                        }
                    }else{
                        if(visited[ni][nj] > turn+1){
                            visited[ni][nj] = turn+1;
                            pq.offer(new Node(ni,nj,turn+1,d));
                        }
                    }

            }
        }
        System.out.println(ans);
    }
}
