package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_2665_미로만들기_Gold_4 {

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

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]map = new int[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][]visited = new boolean[N][N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        visited[0][0] = true;
        int answer = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int i = cur.i; int j = cur.j; int cnt = cur.cnt;
            if(i==N-1&&j==N-1){
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] =  true;
                    if(map[ni][nj]==1) pq.offer(new Node(ni,nj,cnt));
                    else pq.offer(new Node(ni,nj,cnt+1));
                }
            }
        }
        System.out.println(answer);
    }
}
