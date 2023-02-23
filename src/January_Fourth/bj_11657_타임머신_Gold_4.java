package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_11657_타임머신_Gold_4 {

    static class Node{
        int to,weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
   static int N,M,dist[];
   static List<List<Node>> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        list=  new ArrayList<>();

        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from =  Integer.parseInt(st.nextToken());
            int to =  Integer.parseInt(st.nextToken());
            int weight =  Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }

        Arrays.fill(dist,987654321);
        dist[1] = 0;

        for(int i=1;i<N;i++){
            for(int j=1;j<N+1;j++){
                for(Node next : list.get(j)){
                    if(dist[next.to] > dist[j] + next.weight){
                        dist[next.to] = dist[j] + next.weight;
                    }
                }
            }
        }
        boolean flag = false;
        for(int j=1;j<N+1;j++){
            for(Node next : list.get(j)){
                if(dist[next.to] > dist[j] + next.weight){
                    System.out.println(-1);
                    flag = true;
                    break;
                }
            }
        }

        if(!flag){
            StringBuilder sb = new StringBuilder();
            for(int i=2;i<N+1;i++) {
                if(dist[i]==987654321) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
            System.out.println(sb.toString());
        }

    }
}
