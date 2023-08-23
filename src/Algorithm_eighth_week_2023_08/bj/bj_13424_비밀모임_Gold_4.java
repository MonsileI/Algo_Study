package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_13424_비밀모임_Gold_4 {

    static class Node implements Comparable<Node>{
        int to,weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int N,M;
    static List<List<Node>> list;


    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int TC = Integer.parseInt(br.readLine());
       StringTokenizer st = null;
       StringBuilder sb = new StringBuilder();
       for(int t=0;t<TC;t++){
           st = new StringTokenizer(br.readLine()," ");
           N = Integer.parseInt(st.nextToken());
           M = Integer.parseInt(st.nextToken());
           list = new ArrayList<>();
           for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
           for(int i=0;i<M;i++){
               st = new StringTokenizer(br.readLine()," ");
               int from = Integer.parseInt(st.nextToken());
               int to = Integer.parseInt(st.nextToken());
               int weight = Integer.parseInt(st.nextToken());
               list.get(from).add(new Node(to,weight));
               list.get(to).add(new Node(from,weight));
           }
           int K = Integer.parseInt(br.readLine());
           int[][]result = new int[K][N+1];
           st = new StringTokenizer(br.readLine());
           for(int i=0;i<K;i++) {
               int num = Integer.parseInt(st.nextToken());
               result[i] = dijks(num);
           }
           int ans = 0;
           int min = 987654321;
           for(int i=N;0<i;i--){
               int sum = 0;
               for(int j=0;j<K;j++){
                   sum += result[j][i];
               }
               if(sum<=min){
                   min = sum;
                   ans = i;
               }
           }
           sb.append(ans+"\n");
       }
        System.out.println(sb.toString());
    }
       static int[] dijks(int start){

        int []dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[]visited = new boolean[N+1];
        q.offer(new Node(start,0));
        while(!q.isEmpty()){
            Node node = q.poll();

            if(visited[node.to]) continue;
            visited[node.to] = true;
            for(Node next : list.get(node.to)){
                if(dist[next.to] > dist[node.to]+next.weight){
                    dist[next.to] = dist[node.to]+next.weight;
                    q.offer(new Node(next.to,dist[next.to]));
                }
            }
        }

        return dist;
    }
}
