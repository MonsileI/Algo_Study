package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1197_최소스패닝트리_Gold_4 {

    static class Node implements Comparable<Node>{
        int from;int to;int weight;

        public Node(int from,int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static int N;
    static int[]parent;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<N+1;i++) parent[i] = i;
        pq = new PriorityQueue<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Node(from,to,weight));
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(find(node.from)!=find(node.to)){
                union(node.from,node.to);
                answer += node.weight;
            }
        }
        System.out.println(answer);


    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num] = find(parent[num]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB){
            parent[rootA] = rootB;
        }else{
            parent[rootB] = rootA;
        }
    }
}
