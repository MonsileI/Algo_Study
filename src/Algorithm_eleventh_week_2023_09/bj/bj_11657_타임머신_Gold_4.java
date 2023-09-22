package Algorithm_eleventh_week_2023_09.bj;



import java.util.*;
import java.io.*;

public class bj_11657_타임머신_Gold_4 {
    static class Node {
        int from;int to;int weight;

        public Node(int from,int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


    }
    static int N;
    static List<Node> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Node(from,to,weight));
        }
        long[] dist = new long[N+1];
        Arrays.fill(dist,987654321);
        dist[1] = 0;
        for(int i=0;i<N-1;i++){
            for(int j=0;j<M;j++){
                Node node = list.get(j);

                if(dist[node.from]!=987654321 && dist[node.to] > dist[node.from]+ node.weight){
                    dist[node.to] = dist[node.from]+ node.weight;
                }
            }
        }
        boolean flag = true;
        //음수 가중치 확인
        for (int i = 0; i < M; i++) {
            Node node = list.get(i); //현재 간선

            //현재 간선의 들어오는 정점에 대해 비교 -> 더 작은 값 생기면 음수 사이클 존재
            if (dist[node.from] != 987654321 && dist[node.to] > dist[node.from] + node.weight) {
                flag = false;
                break;
            }
        }
        if(!flag) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=2;i<N+1;i++){
                if(dist[i]==987654321) dist[i] = -1;
                sb.append(dist[i]+"\n");
            }
            System.out.println(sb.toString());
        }
    }
}
