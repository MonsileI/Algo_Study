package Algorithm_tenth_week_2023_09.bj;

import java.io.*;
import java.util.*;

public class bj_21940_가운데에서만나기_Gold_4 {

    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node( int to, int weight) {

            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int N;
    static int[][]dists;
    static List<List<Node>> list;
    static int K;
    public static void main(String[] args) throws Exception{
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
        }

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        dists = new int[K][N+1];
        for(int i=0;i<K;i++){
            int s = Integer.parseInt(st.nextToken());
            dists[i] = dijk(s);
            dists[i][0] = s;
        }
        int []ans = new int[N+1];
        int min = 987654321;
        for(int i=1;i<N+1;i++){
            int sum  =0;
            for(int j=0;j<K;j++){
                sum += dists[j][i];
                sum += comeback(i,dists[j][0]);
            }
            min = Math.min(sum,min);
            ans[i] = sum;
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(ans));
        for(int i=1;i<N+1;i++){
            if(ans[i]==min) sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
    static int comeback(int start,int end){
        int res = 0;
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        boolean[]visited= new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to]>dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        res = dist[end];

        return res;
    }
    static int[]dijk(int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        boolean[]visited= new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to]>dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
