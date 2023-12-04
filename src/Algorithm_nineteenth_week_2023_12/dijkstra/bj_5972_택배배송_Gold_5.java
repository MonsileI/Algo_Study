package Algorithm_nineteenth_week_2023_12.dijkstra;
import java.util.*;
import java.io.*;
public class bj_5972_택배배송_Gold_5 {
    static class Node {
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int N;
    static List<List<Node>> list;
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[1] = 0;
        boolean[]visited = new boolean[N+1];

        for(int i=1;i<N+1;i++){
            int nodeValue = INF;
            int nodeIndex = 0;
            for(int j=1;j<N+1;j++){
                if(!visited[j]&&dist[j]<nodeValue){
                    nodeValue = dist[j];
                    nodeIndex = j;
                }
            }
            visited[nodeIndex] = true;
            for(Node next : list.get(nodeIndex)){
                if(dist[next.to] > dist[nodeIndex]+next.weight){
                    dist[next.to] = dist[nodeIndex] + next.weight;
                }
            }
        }

        int ans = dist[N];
        System.out.println(Arrays.toString(dist));
        System.out.println(ans);

    }

}
