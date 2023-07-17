package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_18352_특정거리의도시찾기_Silver_2 {

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
    static List<List<Node>> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,1));
            list.get(to).add(new Node(from,1));
        }
        int []dist = new int[N+1];
        boolean[]visited = new boolean[N+1];

        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(S,1));

        Arrays.fill(dist,987654321);

        dist[S] = 0;

        while(!q.isEmpty()) {

            Node c = q.poll();
            int num = c.to;
            int cnt = c.weight;
            if (visited[num]) continue;
            visited[num] = true;
            for (Node next : list.get(num)) {
                if (dist[next.to] > dist[num] + cnt) {
                    dist[next.to] = dist[num] + cnt;
                    q.offer(new Node(next.to, dist[next.to]));
                }
            }

        }
        List<Integer> answer = new ArrayList<>();
        System.out.println(Arrays.toString(dist));
        for(int i=1;i<N+1;i++){
            if(dist[i]==K) answer.add(i);
        }
        if(answer.size()==0) System.out.println(-1);
        else {
            Collections.sort(answer);
            for(int i : answer) System.out.println(i);
        }
    }
}
