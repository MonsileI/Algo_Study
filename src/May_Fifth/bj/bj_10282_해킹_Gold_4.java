package May_Fifth.bj;

import java.io.*;
import java.util.*;

public class bj_10282_해킹_Gold_4 {

    static class Node implements Comparable<Node>{
        int to; int sec;

        public Node(int to, int sec) {
            this.to = to;
            this.sec = sec;
        }


        @Override
        public int compareTo(Node o) {
            return sec - o.sec;
        }
    }

    static int N,M,Start,dist[];
    static List<List<Node>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){

            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Start = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++)list.add(new ArrayList<>());

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.get(to).add(new Node(from,weight));
            }
            dijk();
            int max = 0;
            int answer = 0;
            for(int i=1;i<N+1;i++){
                int num = dist[i];
                if(num!=987654321){
                    answer++;
                    max = Math.max(max,num);
                }
            }
            sb.append(answer).append(" ").append(max).append("\n");

        }
        System.out.println(sb.toString());
    }
    static void dijk(){

        dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[Start] = 0;

        PriorityQueue<Node> q =new PriorityQueue<>();

        q.offer(new Node(Start,0));

        while(!q.isEmpty()){

            Node now = q.poll();
            int sec = now.sec;
            int to = now.to;

            if(dist[to] < sec) continue;

            for(Node next : list.get(to)){
                if(dist[next.to] > dist[to] + next.sec){
                    dist[next.to] = dist[to] + next.sec;
                    q.offer(new Node(next.to, dist[to]+next.sec));
                }
            }

        }





    }
}
