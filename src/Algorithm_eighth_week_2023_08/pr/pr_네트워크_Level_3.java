package Algorithm_eighth_week_2023_08.pr;

import java.util.*;
import java.io.*;
public class pr_네트워크_Level_3 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;

    public static void main(String[] args) {
        int n = 3;
        int[][]computers = {{1, 1, 0}, {1, 1, 1},{0, 1, 1}};
        N = n;
        list = new ArrayList<>();
        visited = new boolean[N];
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(computers[i][j]==1){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int cnt=  0;
        for(int i=0;i<N;i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        visited[node] = true;
        q.offer(node);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
