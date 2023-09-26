package Algorithm_ninth_week_2023_08.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1261_알고스팟_Gold_4 {

    static class Node implements Comparable<Node>{
        int i; int j; int cnt;

        public Node(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }
    static int N,M,map[][];
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        System.out.println(bfs());

    }
    static int bfs(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        visited[0][0] = true;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i; int j=now.j; int cnt = now.cnt;
            if(i==N-1&&j==M-1){
                return cnt;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    if(map[ni][nj]==1){
                        pq.offer(new Node(ni,nj,cnt+1));
                    }else{
                        pq.offer(new Node(ni,nj,cnt));
                    }
                }
            }
        }

        return 0;
    }
}
