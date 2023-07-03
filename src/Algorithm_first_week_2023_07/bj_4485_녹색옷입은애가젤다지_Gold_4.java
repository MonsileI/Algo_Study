package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;

public class bj_4485_녹색옷입은애가젤다지_Gold_4 {
    static class Node implements Comparable<Node>{
        int i;int j;int cnt;

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
    static int answer;
    static int [][]map;
    static boolean[][]visited;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0)break;
            answer = 0;
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            visited[0][0] = true;
            pq.offer(new Node(0,0,map[0][0]));

            InnerLoop:
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int i = cur.i; int j = cur.j; int cnt = cur.cnt;
                if(i==N-1 && j==N-1) {
                    answer = cnt;
                    break InnerLoop;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(!visited[ni][nj]) {
                        visited[ni][nj] = true;
                        pq.offer(new Node(ni,nj,cnt + map[ni][nj]));
                    }

                }
            }
            sb.append("Problem ").append(idx).append(": ").append(answer).append("\n");
            idx++;
        }
        System.out.println(sb.toString());
    }
}
