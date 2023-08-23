package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_1753_최단경로_Gold_4 {

    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static int N;
    static List<List<Node>> list;
    static int[]dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        dijk(start);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) sb.append(dist[i]==Integer.MAX_VALUE ? "INF\n" : dist[i]+"\n");
        System.out.println(sb.toString());
    }
    static void dijk(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        boolean[]visited = new boolean[N+1];
        while(!pq.isEmpty()){
            Node c = pq.poll();
            if(visited[c.to]) continue;
            visited[c.to] = true;
            for(Node next : list.get(c.to)){
                if(dist[next.to] > dist[c.to] + next.weight){
                    dist[next.to] = dist[c.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
    }
}
