package Algorithm_seventh_week_2023_08.bj;

import java.io.*;
import java.util.*;
public class bj_5567_결혼식_Silver_2 {
    static int N;
    static boolean[]visited;

    static List<List<Integer>> list;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);

        }
        bfs(1);
        System.out.println(answer);
    }
    static void bfs(int start){
        visited = new boolean[N+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start,1});
        visited[start] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int now = c[0]; int cnt = c[1];
            for(int next : list.get(now)){
                if(!visited[next]&&cnt<3){
                    answer++;
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
    }
}
