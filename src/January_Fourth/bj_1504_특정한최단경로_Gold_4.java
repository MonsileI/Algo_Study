package January_Fourth;

/*
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
* */
import java.util.*;
import java.io.*;
public class bj_1504_특정한최단경로_Gold_4 {

    static class  Node implements Comparable<Node>{
        int to,weight;

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<List<Node>> list;
    static int N,M,U,V;
    static int dist[];



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
        st = new StringTokenizer(br.readLine()," ");
        U = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        dijk(1);
        int first = dist[U];
        int second = dist[V];

        dijk(U);
        first += dist[V];
        dijk(V);
        first += dist[N];

        dijk(V);
        second += dist[U];
        dijk(U);
        second += dist[N];

        int answer = 200000000;

        if(first==200000000 || second ==200000000) answer = -1;
        else answer = Math.min(first,second);

        System.out.println(answer <= 200000000 ? answer : -1);

    }

    static void dijk(int start){

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist = new int[N+1];
        int INF = 200000000;
        Arrays.fill(dist,INF);
        dist[start] = 0;

        pq.offer(new Node(start,0));


        while(!pq.isEmpty()){

            Node nowNode = pq.poll();

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (dist[nowNode.to] < nowNode.weight) continue;

                for(Node nextNode : list.get(nowNode.to)){
                    if(dist[nextNode.to] > dist[nowNode.to] + nextNode.weight){
                        dist[nextNode.to] = dist[nowNode.to] + nextNode.weight;
                        pq.offer(new Node(nextNode.to, dist[nextNode.to]));
                    }
                }

        }
    }

}
