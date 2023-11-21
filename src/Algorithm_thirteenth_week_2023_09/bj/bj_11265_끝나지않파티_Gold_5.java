package Algorithm_thirteenth_week_2023_09.bj;


import java.util.*;
import java.io.*;
public class bj_11265_끝나지않파티_Gold_5 {
    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo( Node o) {
            return weight - o.weight;
        }
    }
    static int N;
    static List<List<Node>> list;
    static boolean[]visited;
    static int[][]dist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        int M = Integer.parseInt(st.nextToken());
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){
                if(i==j) {
                    st.nextToken();
                    continue;
                }
                list.get(i).add(new Node(j,Integer.parseInt(st.nextToken())));
            }
        }
        StringBuilder sb = new StringBuilder();
        dist = new int[N+1][N+1];
        for(int i=1;i<N+1;i++) djik(i);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if(dist[from][to]>time)sb .append("Stay here\n");
            else sb.append("Enjoy other party\n");
        }
        System.out.println(sb.toString());

    }
    static void djik(int start){

        visited=  new boolean[N+1];
        Arrays.fill(dist[start],987654321);
        dist[start][start] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[start][next.to] > dist[start][now.to] + next.weight){
                    dist[start][next.to] = dist[start][now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[start][next.to]));
                }
            }
        }

    }
}
