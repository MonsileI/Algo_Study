package Algorithmeighteenth_week_2023_11.복습;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.io.*;
public class bj_1922_네트워크연결_Gold_4 {

    static class Node implements Comparable<Node>{
        int from; int to; int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return weight - o.weight;
        }
    }
    static int[]parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st =null;
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
        int link = 0;
        while(!pq.isEmpty()){
            if(link==N-1) break;
            Node now = pq.poll();
            if(find(now.to)!=find(now.from)){
                ans += now.weight;
                union(find(now.to),find(now.from));
                link++;
            }
        }
        System.out.println(ans);
    }


    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }

    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num]= find(parents[num]);
    }
}
