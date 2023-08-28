package Algorithm_eighth_week_2023_08.pr;

import java.util.*;

public class pr_합승택시요금_Level_3_re {
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
    static int distAll[], distA[],distB[];

    public static void main(String[] args) {
        int n =6; int s =4; int a=6; int b=2;
        N = n ; S = s; A = a;B= b;
        int[][]fares = {{4, 1, 10},{3, 5, 24},{5, 6, 2},{3, 1, 41},{5, 1, 24},{4, 6, 50},{2, 4, 66},{2, 3, 22},{1, 6, 25}};
        int size = fares.length;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<size;i++){
            int from = fares[i][0];
            int to  = fares[i][1];
            int weight = fares[i][2];
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        distAll = dijk(S);
        distA = dijk(A);
        distB = dijk(B);
        int min = 987654321;
        for(int i=1;i<N+1;i++){
            int total = distAll[i] + distA[i] + distB[i];
            min = Math.min(min,total);
        }
        System.out.println(min);


    }
    static int[] dijk(int start){
        int []tmp = new int[N+1];
        Arrays.fill(tmp,Integer.MAX_VALUE);
        tmp[start] = 0;
        boolean[]visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){

                if(tmp[next.to]> tmp[now.to]+next.weight){
                    tmp[next.to] = tmp[now.to]+next.weight;
                    pq.offer(new Node(next.to,tmp[next.to]));
                }

            }
        }

        return tmp;
    }
}
