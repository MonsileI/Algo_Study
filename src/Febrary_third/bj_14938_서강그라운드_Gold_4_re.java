package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_14938_서강그라운드_Gold_4_re {

    static class Node implements Comparable<Node>{

        int to, weigth;
        public Node(int to, int weigth) {
            this.to = to;
            this.weigth = weigth;
        }
        @Override
        public int compareTo(Node o) {
            return weigth - o.weigth;
        }
    }

    static List<List<Node>> list;
    static int[]items;
    static int n,m,answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //정점개수
        m = Integer.parseInt(st.nextToken()); //탐색가능범위
        int r = Integer.parseInt(st.nextToken()); //간선개수
        items = new int[n + 1];
        answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) items[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to, weight));
            list.get(to).add(new Node(from, weight));
        }

        for(int i=1;i<=n;i++) dij(i);

        System.out.println(answer);

    }

    static void dij(int start){

        int [] dist= new int[n+1];

        boolean[]visited = new boolean[n+1];

        Arrays.fill(dist, 987654321);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(visited[now.to]) continue;

            visited[now.to] = true;

            for(Node next : list.get(now.to)){

                if(visited[next.to]) continue;

                if(dist[next.to] > dist[now.to]+next.weigth){
                    dist[next.to] = dist[now.to]+next.weigth;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }


        int tmp = 0;
        for(int i=1;i<n+1;i++) if(dist[i] <= m) tmp += items[i];
        answer = Math.max(answer,tmp);


    }
}
