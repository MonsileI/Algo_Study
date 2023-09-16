package Algorithm_eleventh_week_2023_09.bj;


import java.util.*;
import java.io.*;
public class bj_20007_떡돌리기_Gold_4 {

    static class Node implements Comparable<Node>{
        int to;int weight;

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
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));

        }
        dist = new int[N];
        dijk(start);
        Arrays.sort(dist);
        int answer = 1;
        int power = 0;
        for(int i=1;i<N;i++){
            if(max<dist[i]) {
                answer = -1;
                break;
            }
            for(int j=0;j<2;j++) {
                if (power + dist[i] < max) {
                    answer++;
                    power = max - dist[i];
                } else {
                    power += dist[i];
                }
            }
        }

        System.out.println(answer);
    }
    static void dijk(int start){

        Arrays.fill(dist,987654321);
        dist[start] = 0;
        boolean[]visited = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
    }
}
