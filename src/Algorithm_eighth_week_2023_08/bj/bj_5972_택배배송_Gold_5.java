package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_5972_택배배송_Gold_5 {
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
    static boolean[]visited;
    static int[]dist;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        System.out.println(dijks());
    }
    static int dijks(){
        dist = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }

        }


        return dist[N];
    }
}
