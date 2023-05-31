package May_Fifth.bj;

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
    static int N,M;
    static List<List<Node>> list;

    static int[]dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        list= new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }

        dijk();
        System.out.println(dist[N]);
    }
    static void dijk(){

        dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){

            Node n = pq.poll();
            int now = n.to;
            int weight = n.weight;

            if(dist[now]<weight) continue;

            for(Node node : list.get(now)){

                if(dist[node.to] > dist[now]+node.weight ){
                    dist[node.to] = dist[now]+node.weight;
                    pq.offer(new Node(node.to, dist[now]+node.weight));
                }

            }

        }

    }
}
