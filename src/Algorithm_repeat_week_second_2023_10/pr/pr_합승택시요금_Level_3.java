package Algorithm_repeat_week_second_2023_10.pr;

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
    static int N,S,A,B;
    static List<List<Node>> list;
    public static void main(String[] args) {
        int n =  7;
        int s=   3;
        int a = 4;
        int b = 1;
        int [][] fares = {{5, 7, 9},{4, 6, 4},{3, 6, 1},{3, 2, 3},{2, 1, 6}};
        N = n; S = s; A = a; B = b;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            list.get(fares[i][0]).add(new Node(fares[i][1],fares[i][2]));
            list.get(fares[i][1]).add(new Node(fares[i][0],fares[i][2]));
        }
        int ans = 987654321;
        int INF = 987654321;
        int[]getTexi = djik(S);
        for(int i=1;i<N+1;i++){
            int []dist = djik(i);
            if(getTexi[i]==INF||dist[A]==INF||dist[B]==INF)continue;
            int sum = getTexi[i] + dist[A] + dist[B];
            ans = Math.min(ans,sum);
        }
        System.out.println(ans);
    }
    static int[] djik(int s){
        int[]dist = new int[N+1];
        boolean[]visited = new boolean[N+1];
        int INF = 987654321;
        Arrays.fill(dist,INF);
        dist[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(s,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    q.offer(new Node(next.to,dist[next.to]));
                }
            }
        }

        return dist;
    }
}
