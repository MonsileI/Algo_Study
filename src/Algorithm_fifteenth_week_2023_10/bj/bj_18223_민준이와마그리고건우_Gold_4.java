package Algorithm_fifteenth_week_2023_10.bj;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.io.*;
public class bj_18223_민준이와마그리고건우_Gold_4 {

    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return weight - o.weight;
        }
    }
    static List<List<Node>> list;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }

        int len1 = djik(1,G) + djik(G,N);
        int len2 = djik(1,N);
        System.out.println(len1==len2 ? "SAVE HIM"  :"GOOD BYE");
    }
    static int djik(int start,int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int []dist = new int[N+1];
        Arrays.fill(dist,987654321);
        boolean[]visited = new boolean[N+1];
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            if(now.to==end) break;
            for(Node next : list.get(now.to)){
                if(dist[next.to]>dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist[end];
    }
}
