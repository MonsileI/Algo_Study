package Algorithm_eighteenth_week_2023_11.복습;

import java.util.*;
import java.io.*;
public class bj_1197_최소스패닝트리_Gold_4 {
    static class Node implements Comparable<Node>{
        int from; int to; int weight;

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
    static int []parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a,b,w));
            pq.offer(new Node(b,a,w));
        }
        int ans = 0;
        int line = 0;
        while(!pq.isEmpty()){
            if(line==N-1) break;
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                ans += now.weight;
                union(now.from,now.to);
                line++;
            }
        }
        System.out.println(ans );

    }

    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
