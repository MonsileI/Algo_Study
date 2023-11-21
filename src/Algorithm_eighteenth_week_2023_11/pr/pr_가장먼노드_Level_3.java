package Algorithm_eighteenth_week_2023_11.pr;
import java.util.*;

public class pr_가장먼노드_Level_3 {
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
    static List<List<Integer>> list;
    static int N;
    static int max = 0;
    public static void main(String[] args) {
        int n =6;
        N = n;
        int[][]vertex = {{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}};
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<vertex.length;i++){
            int a = vertex[i][0]; int b = vertex[i][1];
            list.get(a).add(b); list.get(b).add(a);
        }

        int []result = dijk();
        int ans = 0;
        for(int i=2;i<N+1;i++) if(result[i]==max) ans++;
        System.out.println(ans);

    }

    static int[] dijk(){
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[1] = 0;
        boolean[]visited=  new boolean[N+1];
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(int next : list.get(now.to)){
                if(dist[next]>dist[now.to]+1){
                    dist[next] = dist[now.to]+1;
                    pq.offer(new Node(next,dist[next]));
                }
            }
        }
        for(int i =2;i<N+1;i++) max = Math.max(max,dist[i]);
        return dist;
    }
}
