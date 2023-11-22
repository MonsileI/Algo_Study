package Algorithm_eighteenth_week_2023_11.pr;

import java.util.*;

public class pr_합승택시요금_Level_3 {
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
    static int INF = 987654321;
    static int Solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int w = fares[i][2];
            list.get(from).add(new Node(to,w));
            list.get(to).add(new Node(from,w));
        }
        int[]originDist = dijk(s);
        int[]aDist =dijk(a);
        int[]bDist =dijk(b);
        int answer = INF;
        for(int i=1;i<N+1;i++){
            if(originDist[i]==INF||aDist[i]==INF||bDist[i]==INF) continue;
            answer = Math.min(answer,originDist[i]+aDist[i]+bDist[i]);
        }
        return answer;
    }
    static int[]dijk(int start){
        int[]dist = new int[N+1];
        boolean[]visited = new boolean[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }

            }
        }
        return dist;
    }


    public static void main(String[] args) {

        int n = 6; int s=4;int a =5; int b=6;
        int[][]fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};
        System.out.println(Solution(n,s,a,b,fares));
    }

}
