package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1647_도시분할계획_Gold_4 {

    static class Node implements Comparable<Node>{
        int from;int to;int weight;

        public Node(int from, int to, int weight) {
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
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[]parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a,b,weight));
            pq.offer(new Node(b,a,weight));
        }
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;

        int answer = 0;
        int max = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                union(now.from,now.to);
                answer += now.weight;
                max = Math.max(max,now.weight);
            }
        }
        answer -= max;
        System.out.println(answer);

    }

    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB){
            parents[rootB] = rootA;
        }else{
            parents[rootA] = rootB;
        }
    }
}
