package Algorithm_ninth_week_2023_08.pr;

import java.util.*;
public class pr_부대복귀_Level_3 {

    static List<List<Integer>> list;
    static int N,R[][],S[],D;
    static int[]visited;
    public static void main(String[] args) {
        int n = 3;
        int [][]roads = {{1, 2},{2,3}};
        int[]sources = {2,3};
        int destination = 1;
        N = n ; R = roads; S = sources; D = destination;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<R.length;i++){
            int from = roads[i][0];
            int to = roads[i][1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        int[]answer= new int[S.length];
        bfs(D);
        for(int i=0;i<S.length;i++){
            int ans = visited[S[i]]==0 ? -1 : visited[S[i]];
            if(S[i]==D) ans = 0;
            answer[i] = ans;
        }
        System.out.println(Arrays.toString(answer));
    }
    static void bfs(int start){

        visited = new int[N+1];
        visited[start] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list.get(now)){
                if(visited[next]==0&&next!=start){
                    visited[next] = visited[now]+1;
                    q.offer(next);
                }
            }
        }
    }
}
