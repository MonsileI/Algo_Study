package Algorithm_repeat_week_second_2023_10.pr;


import java.util.*;
public class pr_섬연결하기_Level_3 {

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

    static int[]parents;

    public static void main(String[] args) {
        int n =4;
        int [][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        PriorityQueue<Node> q = new PriorityQueue<>();
        parents = new int[n+1];
        for(int i=1;i<n+1;i++) parents[i] = i;
        for(int i=0;i<costs.length;i++){
            q.offer(new Node(costs[i][0],costs[i][1],costs[i][2]));
            q.offer(new Node(costs[i][1],costs[i][0],costs[i][2]));
        }
        int answer = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(find(now.from)!=find(now.to)){
                answer += now.weight;
                union(now.from,now.to);
            }
        }
        System.out.println(answer);
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;

    }
}
