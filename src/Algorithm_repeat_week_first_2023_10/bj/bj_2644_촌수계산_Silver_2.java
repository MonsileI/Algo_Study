package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2644_촌수계산_Silver_2 {
    static int N;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int f= Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.get(f).add(s);
            list.get(s).add(f);
        }
        int answer = bfs(a,b);
        System.out.println(answer);
    }
    static int bfs(int a,int b){
        boolean[]visited = new boolean[N+1];
        visited[a] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{a,0});
        while(!q.isEmpty()){
            int []c = q.poll();
            int node = c[0]; int cnt = c[1];
            if(node==b) return cnt;
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }

        return -1;
    }
}
