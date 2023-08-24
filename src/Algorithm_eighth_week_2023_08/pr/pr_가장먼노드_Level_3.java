package Algorithm_eighth_week_2023_08.pr;

import java.util.*;
public class pr_가장먼노드_Level_3 {

    static List<List<Integer>> list;
    static int N;
    static boolean[]visited;
    static int[]dist;
    static int max;

    public static void main(String[] args) {
        int n =6;
        int[][]vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        N = n;
        int M = vertex.length;
        list = new ArrayList<>();
        visited = new boolean[N+1];
        dist = new int[N+1];
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            int from = vertex[i][0];
            int to = vertex[i][1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        bfs();
        int answer = 0;
        for(int i=1;i<N+1;i++){
            if(dist[i]==max) answer++;
        }

        System.out.println(answer);
    }
    static void bfs(){

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,0});
        while(!q.isEmpty()){
            int [] c = q.poll();
            int now = c[0];
            int cnt = c[1];
            visited[now] = true;
            dist[now] = cnt;
            max = Math.max(max,cnt);
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
    }
}
