package Algorithm_seventh_week_2023_08.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj_6497_전력난_Gold_4_mySelf {
    static class Node implements Comparable<Node>{
        int start;int end;int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static int[]parent;
    static List<Node> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (M == 0 && N == 0) break;
            list = new ArrayList<>();
            int cost = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.add(new Node(from, to, weight));
                cost += weight;
            }
            Collections.sort(list);
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            int minCost = 0; //최소비용
            int size = list.size();
            for(int i=0;i<size;i++){
                Node node = list.get(i);
                if(find(node.start)!=find(node.end)){
                    minCost += node.weight;
                    union(node.start,node.end);
                }
            }
            sb.append(cost-minCost+"\n");
        }
        System.out.println(sb.toString());
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB){
            parent[rootB] = rootA;
        }
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }

}
