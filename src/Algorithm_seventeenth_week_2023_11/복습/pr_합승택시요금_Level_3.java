package Algorithm_seventeenth_week_2023_11.복습;

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
            return weight -o.weight;
        }
    }

    static List<List<Node>> list;
    static int N;
    public static void main(String[] args) {
        int n = 6; int s = 4; int a = 5; int b = 6;
        N = n;
        int[][]fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            int fir = fares[i][0]; int sec= fares[i][1]; int w= fares[i][2];
            list.get(fir).add(new Node(sec,w));
            list.get(sec).add(new Node(fir,w));
        }
        int[]origin = djik(s);
        int[]distA = djik(a);
        int[]distB = djik(b);
        int min = 987654321;
        for(int i=1;i<n+1;i++){
            if(origin[i]==987654321 || distA[i]==987654321||distB[i]==987654321) continue;
            int sum = origin[i]+distA[i]+distB[i];
            min = Math.min(min,sum);
        }
        System.out.println(min);
    }

    static int[] djik(int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        boolean[]visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
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
