package Algorithm_ninth_week_2023_08.복습;

import java.util.*;
import java.io.*;
public class bj_16398_행성연결_Gold_4 {
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
    static int[]parent;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        parent = new int[N+1];
        for(int i=1;i<N+1;i++) parent[i] = i;
        StringTokenizer st = null;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                if(i==j) {
                    st.nextToken();
                    continue;
                }
                pq.offer(new Node(i,j,Integer.parseInt(st.nextToken())));
            }
        }
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                union(now.from,now.to);
                answer += now.weight;
            }
        }
        System.out.println(answer);
    }

    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num] = find(parent[num]);
    }
}
