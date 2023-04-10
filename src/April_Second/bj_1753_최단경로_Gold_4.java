package April_Second;

import java.util.*;
import java.io.*;
public class bj_1753_최단경로_Gold_4 {
    static class Node implements Comparable<Node>{

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        int to, weight;
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());
        int[]dist = new int[N+1];
        List<List<Node>> list = new ArrayList<>();

        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());

        for(int i=0;i<V;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to,weight));
        }
        Arrays.fill(dist,987654321);
        dist[S] = 0;
        boolean[]visited = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(S,0));

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(visited[now.to]) continue;

            visited[now.to] = true;

            for(Node next : list.get(now.to)){
                if(!visited[next.to] && dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }

        }

        for(int i=1;i<N+1;i++) System.out.println(dist[i]==987654321 ? "INF" : dist[i]);
    }
}
