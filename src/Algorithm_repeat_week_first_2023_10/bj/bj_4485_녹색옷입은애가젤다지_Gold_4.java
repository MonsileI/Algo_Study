package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_4485_녹색옷입은애가젤다지_Gold_4 {

    static class Node implements Comparable<Node>{
        int i; int j; int weight;

        public Node(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static int N;
    static int[][]map;
    static int[][]move= {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String p = "Problem ";
        StringTokenizer st=  null;
        int TC = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = calc();
            sb.append(p + TC + ": " + ans + "\n");
            TC++;
        }
            System.out.println(sb.toString());
    }
    static int calc(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,map[0][0]));
        visited[0][0] = true;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i;int j=now.j; int weight = now.weight;
            if(i==N-1&&j==N-1){
                return weight;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj)continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    pq.offer(new Node(ni,nj,weight+map[ni][nj]));
                }
            }
        }
        return 0;
    }
}
