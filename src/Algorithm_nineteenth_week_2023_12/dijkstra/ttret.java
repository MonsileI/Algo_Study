package Algorithm_nineteenth_week_2023_12.dijkstra;

import java.util.*;
import java.io.*;
public class ttret {

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

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //O(N^2) --
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        int[]dist = new int[N+1]; //[0,0,0,0];
        boolean[]visited= new boolean[N+1];
        int INF = 987654321;
        Arrays.fill(dist,INF);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){ //10 3 2 5 -> 2 3 5 10
            Node now =pq.poll();
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
//V 간선 //E 정점 O(E^2) -> O(ElogV)