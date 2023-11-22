package Algorithm_eighteenth_week_2023_11.bj;

import java.util.*;
import java.io.*;
public class bj_12843_주간미팅_Gold_4 {

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
    static int INF = 987654321;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int P  = Integer.parseInt(st.nextToken()); //사람수
        N = Integer.parseInt(st.nextToken()); //정점
        int M = Integer.parseInt(st.nextToken()); //간선
        st = new StringTokenizer(br.readLine()," ");
        int KIST = Integer.parseInt(st.nextToken());
        int CR = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[P];
        for(int i=0;i<P;i++) arr[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        int[]KISTDist = dijk(KIST);
        int[]CRDist = dijk(CR);
        int ans = 0;
        for(int i=0;i<P;i++){
            int k = KISTDist[arr[i]] == INF ? -1 : KISTDist[arr[i]];
            int c = CRDist[arr[i]] == INF ? -1 : CRDist[arr[i]];
            ans += (k+c);
        }
        System.out.println(ans);
    }

    static int[] dijk(int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        boolean[]visited=  new boolean[N+1];
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
        return dist;
    }
}
