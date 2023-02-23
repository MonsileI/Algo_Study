package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_14938_서강그라운드_Gold_4 {

    static class Node implements Comparable<Node>{

        int to, weigth;
        public Node(int to, int weigth) {
            this.to = to;
            this.weigth = weigth;
        }
        @Override
        public int compareTo(Node o) {
            return weigth - o.weigth;
        }
    }

    static List<List<Node>> list;
    static int[]items;
    static int n,m,answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); //정점개수
        m = Integer.parseInt(st.nextToken()); //탐색가능범위
        int r = Integer.parseInt(st.nextToken()); //간선개수
        items = new int[n+1];
        answer  = 0;
        st= new StringTokenizer(br.readLine()," ");
        for(int i=1;i<n+1;i++) items[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        //===============여기까지 인풋===========================

        for(int i=1;i<n+1;i++) dis(i);

        System.out.println(answer);


    }

    static void dis(int start){

        int[] dist = new int[n+1];

        Arrays.fill(dist,987654321);

        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();

        boolean[]visited = new boolean[n+1];

        q.offer(new Node(start,0));

        while(!q.isEmpty()){

            Node now = q.poll();

            if(!visited[now.to]) {
                visited[now.to] = true;

                for (Node nextNode : list.get(now.to)) {
                    if(!visited[nextNode.to]){
                        if (dist[nextNode.to] > dist[now.to] + nextNode.weigth) {
                            dist[nextNode.to] = dist[now.to] + nextNode.weigth;
                            q.offer(new Node(nextNode.to, dist[nextNode.to]));

                        }
                    }
                }
            }
        }
        int tmp = 0;
        for(int i=1;i<n+1;i++){
            if(dist[i]<=m) tmp += items[i];
        }

        answer = Math.max(answer,tmp);

    }
}
