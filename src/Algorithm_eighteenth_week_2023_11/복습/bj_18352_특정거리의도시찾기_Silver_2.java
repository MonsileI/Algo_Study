package Algorithm_eighteenth_week_2023_11.복습;

import java.util.*;
import java.io.*;
public class bj_18352_특정거리의도시찾기_Silver_2 {

    static class Node implements Comparable<Node>{
        int to; int cnt;

        public Node(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); int S = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        //시작도시부터 도착도시까지 M거리
        boolean[]visited=  new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S,0));
        visited[S] = true;
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Node c = pq.poll();
            int now = c.to; int cnt = c.cnt;
            if(cnt==K) ans.add(now);
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next]  = true;
                    pq.offer(new Node(next,cnt+1));
                }
            }
        }
        if(ans.isEmpty()) System.out.println(-1);
        else{
            Collections.sort(ans);
            StringBuilder sb=  new StringBuilder();
            for(int i : ans) sb.append(i+"\n");
            System.out.println(sb.toString());
        }
    }
}
