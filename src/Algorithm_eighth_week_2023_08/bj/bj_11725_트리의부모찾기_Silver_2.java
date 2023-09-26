package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_11725_트리의부모찾기_Silver_2 {
    static int N;
    static int[]parent;
    static List<List<Integer>> list;

    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        list = new ArrayList<>();
        parent = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    parent[next] = node;
                    q.offer(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<N+1;i++){
            sb.append(parent[i]+"\n");
        }
        System.out.println(sb.toString());
    }
}
