package Algorithm_fifth_week_2023_07.bj;

import java.io.*;
import java.util.*;

public class bj_18352_특거리의도시찾기_Silver_2 {
    static class Node implements Comparable<Node>{
        int to;
        int cnt;

        public Node(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }
    static int N,K,X;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); X = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
;           list.get(from).add(to);
        }
        PriorityQueue<Node> q= new PriorityQueue<>();
        q.offer(new Node(X,0));
        List<Integer> answerList = new ArrayList<>();
        boolean[]visited = new boolean[N+1];
        visited[X] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            int cnt = now.cnt;
            if(cnt==K){
                answerList.add(now.to);
                continue;
            }
            for(Integer next : list.get(now.to)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new Node(next,cnt+1));
                }
            }
        }
        if(answerList.isEmpty()) System.out.println(-1);
        else{
            Collections.sort(answerList);
            StringBuilder sb = new StringBuilder();
            for(int i : answerList) sb.append(i+"\n");
            System.out.println(sb.toString());
        }
    }
}
