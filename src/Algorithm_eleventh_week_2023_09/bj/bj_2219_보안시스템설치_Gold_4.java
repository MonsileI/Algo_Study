package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_2219_보안시스템설치_Gold_4 {
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
    static int []dist;
    static boolean[]visited;
    static int answer = 987654321;
    static int answerNode = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        for(int i=N-1;0<i;i--){
            int total = dijk(i);
            if(total<answer){
                answer = total;
                answerNode = i;
            }
        }
        System.out.println(answerNode);
    }
    static int dijk(int start){
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        visited = new boolean[N+1];
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
        int sum =0;
        for(int i=1;i<N+1;i++){
            sum += dist[i];
        }
        return sum;
    }
}
