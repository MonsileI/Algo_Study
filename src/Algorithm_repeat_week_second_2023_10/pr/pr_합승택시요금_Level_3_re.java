package Algorithm_repeat_week_second_2023_10.pr;

import java.lang.reflect.Array;
import java.util.*;

public class pr_합승택시요금_Level_3_re {
    static class Node implements Comparable<Node>{
        int to ; int weight ;

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
    static int[][]F;
    static List<List<Node>> list;
    static int INF = 987654321;

    public static void main(String[] args) {
        int n = 6; int s= 4; int a=6; int b = 2;
        int[][]fares = {{4, 1, 10},{3, 5, 24},{5, 6, 2},{3, 1, 41},{5, 1, 24},{4, 6, 50},{2, 4, 66},{2, 3, 22},{1, 6, 25}};
        F = fares; N = n;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            list.get(fares[i][0]).add(new Node(fares[i][1],fares[i][2]));
            list.get(fares[i][1]).add(new Node(fares[i][0],fares[i][2]));
        }
        int []origin = dijk(s);
        int ans = INF;
        for(int i=1;i<N+1;i++){
           int[]dist = dijk(i);
           int fir = dist[a];
           int sec = dist[b];
           if(fir==INF||sec==INF||origin[i]==INF) continue;
            ans = Math.min(ans,fir+sec+origin[i]);
        }
        System.out.println(ans);
    }

    static int[] dijk(int s){

        int [] dist=  new int[N+1];

        boolean[]visited=  new boolean[N+1];

        Arrays.fill(dist,INF);
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if( dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }

}
