package Algorithm_twenty_week_2023_12.bj;
import java.util.*;
import java.io.*;
public class bj_1504_특정한최단경로_Gold_4 {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

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
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, w));
            list.get(b).add(new Node(a, w));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int fir = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        int[] originDist = djik(1); //1 f s e , 1 s f e
        int[] firDist = djik(fir);
        int[] secDist = djik(sec);
  /*      System.out.println(Arrays.toString(originDist));
        System.out.println(Arrays.toString(firDist));
        System.out.println(Arrays.toString(secDist));*/
        int answer = INF;
        if (originDist[fir] == INF || firDist[sec] == INF || secDist[N] == INF){
            if(originDist[sec]==INF || secDist[fir] == INF || firDist[N] == INF){
                answer = -1;
            }
        }else {
            //1 f s e
            answer = Math.min(answer, originDist[fir] + firDist[sec] + secDist[N]);
            //1 s f e
            answer = Math.min(answer, originDist[sec] + secDist[fir] + firDist[N]);
        }
        System.out.println(answer);

    }

    static int[] djik(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.to]) continue;
            visited[now.to] = true;
            for (Node next : list.get(now.to)) {
                if (dist[next.to] > dist[now.to] + next.weight) {
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }

            }
        }
        return dist;
    }
}
