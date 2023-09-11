package Algorithm_eleventh_week_2023_09.bj;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.io.*;
public class bj_29703_펭귄의하루_Gold_4 {

    static class Node implements Comparable<Node>{
        int i; int j;int cnt;int check;

        public Node(int i, int j, int cnt, int check) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.check = check;
        }

        @Override
        public int compareTo(Node o) {
            return check == o.check ? cnt - o.cnt : -(check - o.check);
        }
    }



    static char[][]map;
    static int N,M;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer = -1;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si = 0; int sj=0;int ei=0;int ej=0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S'){
                    si = i;
                    sj = j;
                    map[i][j] = 'E';
                }
                if(map[i][j]=='H'){
                    ei = i;
                    ej = j;
                }
            }
        }
        bfs(si,sj,ei,ej);
        System.out.println(answer);
    }
    static void bfs(int si,int sj,int ei,int ej){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        pq.offer(new Node(si,sj,0,0));
        visited[si][sj] = true;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i;int j=now.j;int cnt = now.cnt; int check = now.check;
            if(i==ei&&j==ej&&check==1){
                answer = cnt;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]!='D' && !visited[ni][nj]){
                    if(map[ni][nj]=='F') check = 1;
                    visited[ni][nj] = true;
                    pq.offer(new Node(ni,nj,cnt+1,check));
                }
            }
        }

    }
}
