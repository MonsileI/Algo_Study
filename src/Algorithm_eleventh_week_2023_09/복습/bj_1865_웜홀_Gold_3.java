package Algorithm_eleventh_week_2023_09.복습;

import java.util.*;
import java.io.*;
public class bj_1865_웜홀_Gold_3 {
    static class Node {
        int from;int to; int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }
    static long [] dist;
    static int N,M,W;
    static List<Node> list;
    public static void main(String[] args)throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<tc;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            dist = new long[N+1];
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.add(new Node(from,to,weight));
                list.add(new Node(to,from,weight));
            }
            for(int i=0;i<W;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.add(new Node(from,to,-weight));
            }
            int INF = 987654321;
            Arrays.fill(dist,INF);
            dist[1] = 0;
            int length = M+W;
            for(int i=0;i<N-1;i++){
                for(int j=0;j<length;j++){
                    Node node = list.get(j);
                    if(dist[node.from]!=INF && dist[node.to] > dist[node.from] + node.weight){
                        dist[node.to] = dist[node.from] + node.weight;
                    }

                }
            }
            boolean flag = true;
            for(int j=0;j<length;j++){
                Node node = list.get(j);
                if(dist[node.from]!=INF && dist[node.to] > dist[node.from] + node.weight){
                    sb.append("NO\n");
                    flag = false;
                    break;
                }

            }
            if(flag) sb.append("YES\n");
        }
        System.out.println(sb.toString());
    }
}
