package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_14621_나만안되는연애_Gold_3 {

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
    static int N;
    static boolean[]MW;
    static PriorityQueue<Node> pq;

    static int[]parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        MW = new boolean[N+1];
        parents = new int[N+1];

        for(int i=1;i<N+1;i++){
            char ch = st.nextToken().charAt(0);
            if(ch=='M') MW[i] = true;
            parents[i] = i;
        }
        pq = new PriorityQueue<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(MW[from]==MW[to]) continue;
            pq.offer(new Node(from,to,weight));
            pq.offer(new Node(to,from,weight));
        }
        int cnt = 0;
        int answer = 0;
        while(!pq.isEmpty()){
            Node  now =pq.poll();
            if(find(now.from)!=find(now.to)){
                union(now.from,now.to);
                answer += now.weight;
                cnt++;
            }
        }

        System.out.println(cnt!=N-1 ? -1 : answer);
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

    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);

    }
}
