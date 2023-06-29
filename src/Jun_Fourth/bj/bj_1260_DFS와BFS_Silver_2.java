package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_1260_DFS와BFS_Silver_2 {
    static int N,M,S;
    static boolean[][]arr;
    static int[]tmp;
    static boolean[]visited;
    static boolean flag;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        tmp = new int[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = true;
            arr[to][from] = true;
        }
        tmp[1] = S;
        visited[S] = true;
        cnt = 1;
        dfs(S);
        System.out.println();
        bfs();
    }
    static void bfs(){
        visited = new boolean[N+1];
        visited[S] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        while(!q.isEmpty()){

            int node = q.poll();
            System.out.print(node+" ");

            for(int i=1;i<N+1;i++){
                if(!visited[i] && arr[node][i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }

        }
    }
    static void dfs(int node){

        visited[node] = true;
        System.out.print(node+" ");
        for(int i=1;i<N+1;i++){
            if(!visited[i] && arr[node][i]) dfs(i);
        }
    }
}
