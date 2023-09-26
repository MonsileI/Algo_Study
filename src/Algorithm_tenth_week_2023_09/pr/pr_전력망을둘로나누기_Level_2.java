package Algorithm_tenth_week_2023_09.pr;

import java.util.*;

public class pr_전력망을둘로나누기_Level_2 {
    static int N;
    static List<List<Integer>> list;
    static int answer = 987654321;
    static int[][]W;
    static int M;
    public static void main(String[] args) {
        int n = 9;
        int [][]wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        N = n;
        W = wires;
        M = wires.length;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());

        for(int i=0;i<M;i++) dfs(i);

        System.out.println(answer);
    }
    static void calc(int start){
        int cnt = 1;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[]visited = new boolean[N+1];
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
        }
        answer = Math.min(answer,Math.abs(N-(cnt*2)));
    }
    static void dfs(int delete){

        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        int start = 0;
        for(int i=0;i<M;i++){
            if(i==delete) continue;
            list.get(W[i][0]).add(W[i][1]);
            list.get(W[i][1]).add(W[i][0]);
            if(start==0) start = W[i][0];
        }
        calc(start);
    }
}
