package Algorithm_fifth_week_2023_07.st;

import java.util.*;
import java.io.*;
public class st_출퇴근길_Level_3 {
    static int N,S,E;
    static List<List<Integer>> list;
    static boolean visitedS[],visitedE[];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visitedS = new boolean[N+1];
        visitedE = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
        }
        st = new StringTokenizer(br.readLine()," ");
        S = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
        visitedS[S] = true;
        bfs(S,E,visitedS);
        visitedE[E] = true;
        bfs(E,S,visitedE);
        for(int i=1;i<N+1;i++){
            if(i!=S && i!=E){
                if (visitedS[i] && visitedE[i]){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int start,int end,boolean[]visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            if(now==end) continue;
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
