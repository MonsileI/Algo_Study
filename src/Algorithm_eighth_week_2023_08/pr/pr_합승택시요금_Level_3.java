package Algorithm_eighth_week_2023_08.pr;

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

    public static void main(String[] args) {
        int n = 6; int s = 4; int a = 6 ; int b = 2;
        N = n;
        int[][]fares = {{4, 1, 10},{3, 5, 24},{5, 6, 2},{3, 1, 41},{5, 1, 24},{4, 6, 50},{2, 4, 66},{2, 3, 22},{1, 6, 25}};
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int weight = fares[i][2];
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        int min = Integer.MAX_VALUE;
        int [] distS = dijkst(s);
        int []distA = dijkst(a);
        int [] distB = dijkst(b);
    /*    System.out.println(Arrays.toString(distS));
        System.out.println(Arrays.toString(distA));
        System.out.println(Arrays.toString(distB));*/
        //s(시작지)부터 전체 다익스트라 + 각 노드 + a 다익스트라 + b 다익스트라
        for(int i=1;i<N+1;i++){
            int sum = distS[i] + distA[i] + distB[i];
            min = Math.min(min,sum);
        }
        System.out.println(min);

    }
    static int[]dijkst(int start){

        int[]dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[]visited = new boolean[N+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new Node(start,0));
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
