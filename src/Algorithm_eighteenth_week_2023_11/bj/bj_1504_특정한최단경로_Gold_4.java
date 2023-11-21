package Algorithm_eighteenth_week_2023_11.bj;

import java.util.*;
import java.io.*;
public class bj_1504_특정한최단경로_Gold_4 {
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
    static boolean[]visited;
    static List<List<Node>> list;
    static int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //1번에서 N까지
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        st = new StringTokenizer(br.readLine()," ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int ans = 0;
        //첫번째를 먼저 통하는 경우
        int f = djik(1,first);
        int s = djik(first,second);
        int t = djik(second,N);
        if(f==INF||s==INF||t==INF) ans = -1;
        else ans = f+s+t;
        //두번째를 먼저 통하는 경우
        f = djik(1,second);
        s = djik(second,first);
        t = djik(first,N);
        if(f==INF||s==INF||t==INF) System.out.println(ans);
        else{
            if(ans==-1) System.out.println(f+s+t);
            else System.out.println(Math.min(ans,(f+s+t)));
        }
    }
    static int djik(int s,int e){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited=  new boolean[N+1];
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[s] = 0;
        pq.offer(new Node(s,0));
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
        return dist[e];
    }
}
