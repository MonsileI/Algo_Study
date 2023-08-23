package Algorithm_seventh_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_구름이의여행1_Level_3 {
    static int N,K;
    static List<List<Integer>> list;
    static String answer = "NO";
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        bfs();
        System.out.println(answer);
    }

    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[]visited = new boolean[N+1];
        visited[1] = true;
        q.offer(new int[]{1,0});
        while(!q.isEmpty()){
            int []c = q.poll();
            int now = c[0];
            int cnt = c[1];
            if(K<cnt){
                return;
            }
            if(now==N){
                answer = "YES";
                return;
            }
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }

    }
}
