package Algorithm_nineteenth_week_2023_12.dijkstra;
import java.util.*;
import java.io.*;

public class test {
    static class Node implements Comparable<Node>{
        //poll() -> 내가 커스톰한 작은 노드를 먼저 꺼내겠다.
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

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        int[]dist = new int[N+1];
        int INF  = 987564321;
        boolean[]visited = new boolean[N+1];
        Arrays.fill(dist,INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){
            Node now = pq.poll(); //가장 작은애만 뽑는거야
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        System.out.println(dist[N]);
    }
}