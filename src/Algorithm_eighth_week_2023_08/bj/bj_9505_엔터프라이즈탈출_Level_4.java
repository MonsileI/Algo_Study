package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_9505_엔터프라이즈탈출_Level_4 {
    static class Node implements Comparable<Node>{
        int i; int j;int cnt;

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
    static int N,M;
    static int answer;
    static int [][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            int si = 0; int sj = 0;
            answer=  0;
            Map<Character,Integer> hashMap = new HashMap<>();
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine()," ");
                hashMap.put(st.nextToken().charAt(0),Integer.parseInt(st.nextToken()));
            }
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<M;j++){
                    char ch = str.charAt(j);
                    if(ch=='E'){
                        si = i;
                        sj = j;
                        map[i][j] = 0;
                    }else{
                        map[i][j] = hashMap.get(ch);
                    }
                }
            }
            bfs(si,sj);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int y,int x){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][]visited = new boolean[N][M];
        visited[y][x] = true;
        pq.offer(new Node(y,x,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i; int j = now.j; int cnt = now.cnt;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj){
                    answer = cnt;
                    return;
                }
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    pq.offer(new Node(ni,nj,cnt+map[ni][nj]));
                }
            }
        }

    }
}
