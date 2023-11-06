package Algorithm_sixteenth_week_2023_10.복습;
import org.jetbrains.annotations.NotNull;

import java.util.*;
public class pr_택시합승요금_Level_3 {

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
    public static void main(String[] args) {
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        N = n;
        int[][]fares = {{5, 7, 9},{4, 6, 4},{3, 6, 1},{3, 2, 3},{2, 1, 6}};
        //s에서 출발해서 a b 까지 가는거임
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            list.get(fares[i][0]).add(new Node(fares[i][1],fares[i][2]));
            list.get(fares[i][1]).add(new Node(fares[i][0],fares[i][2]));
        }
        int[]origin = dijk(s);
        int[]fir = dijk(a);
        int[]sec = dijk(b);
        //a랑b 깔깔
        int ans = 987654321;
        for(int i=1;i<N+1;i++){
            if(origin[i]==987654321 || fir[i]==987654321 || sec[i] == 987654321) continue;
            int sum = origin[i] + fir[i] + sec[i];
            ans = Math.min(ans,sum);
        }
        System.out.println(ans);
    }
    static int[] dijk(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[]visited = new boolean[N+1];
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to]>dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
