package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_14567_선수과목_Gold_5 {
    static int N;
    static List<List<Integer>> list;

    static int[]dist;
    static int[]ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dist = new int[N+1];
        ans = new int[N+1];
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            dist[to]++;
        }

        calc();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) sb.append(ans[i]+" ");
        System.out.println(sb.toString());

    }
    static void calc(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[]visited = new boolean[N+1];
        for(int i=1;i<N+1;i++) {
            if(dist[i]==0) q.offer(new int[]{i,1});
        }
        while(!q.isEmpty()){
            int []c = q.poll();
            int now = c[0];
            int cnt= c[1];
            ans[now] = cnt;
            visited[now] = true;
            for(int next : list.get(now)){
                dist[next]--;
                if(dist[next]==0 && !visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
    }
}
