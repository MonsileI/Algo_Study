package Algorithmeighteenth_week_2023_11.bj;

import java.util.*;
import java.io.*;
public class bj_1584_게임_Gold_5 {


    static class Node implements Comparable<Node>{
        int i;int j; int cnt;

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

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int [][]map = new int[501][501];
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        //1은 위험, 2는 죽음
        for(int t=0;t<N;t++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken());
            int fj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            int tmpi = Math.min(fi,si);
            int tmpj = Math.min(fj,sj);
            si = Math.max(fi,si);
            sj = Math.max(fj,sj);
            fi = tmpi; fj = tmpj;
            for(int i=fi;i<=si;i++){
                for(int j=fj;j<=sj;j++){
                    map[i][j] = 1;
                }
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int t=0;t<M;t++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken());
            int fj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            int tmpi = Math.min(fi,si);
            int tmpj = Math.min(fj,sj);
            si = Math.max(fi,si);
            sj = Math.max(fj,sj);
            fi = tmpi; fj = tmpj;
            for(int i=fi;i<=si;i++){
                for(int j=fj;j<=sj;j++){
                    map[i][j] = 2;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][]visited = new boolean[501][501];
        visited[0][0] = true;
        pq.offer(new Node(0,0,0));
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int ans = -1;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i; int j = now.j; int cnt = now.cnt;
            if(i==500&&j==500){
                ans = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj= j + move[d][1];
                if(ni<0||nj<0||500<ni||500<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!=2){
                    visited[ni][nj] = true;
                    if(map[ni][nj]==1) pq.offer(new Node(ni,nj,cnt+1));
                    else pq.offer(new Node(ni,nj,cnt));
                }
            }

        }
        System.out.println(ans);
    }
}
