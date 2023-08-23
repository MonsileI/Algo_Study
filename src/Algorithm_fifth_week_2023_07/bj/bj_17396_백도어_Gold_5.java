package Algorithm_fifth_week_2023_07.bj;

import java.io.*;
import java.util.*;

public class bj_17396_백도어_Gold_5 {

    static class Node implements Comparable<Node> {
        int to; long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(weight - o.weight);
        }
    }

    static int N;
    static boolean[] visable;
    static long [] dist;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visable = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int v = Integer.parseInt(st.nextToken());
            if(v==1) visable[i] = true;
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        dist = new long[N];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        dijk();
        System.out.println(dist[N-1]==Long.MAX_VALUE ? -1 : dist[N-1]);
    }
    static void dijk(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[]visited = new boolean[N];
        q.offer(new Node(0,0));

        while(!q.isEmpty()){
            Node c = q.poll();
            if(visited[c.to]) continue;
            visited[c.to] = true;

            for(Node next : list.get(c.to)){
                if(next.to != N-1 && visable[next.to]) continue;
                if(dist[next.to] > dist[c.to] + next.weight ){
                    dist[next.to] = dist[c.to] + next.weight;
                    q.offer(new Node(next.to,dist[next.to]));
                }
            }

        }

    }
}
