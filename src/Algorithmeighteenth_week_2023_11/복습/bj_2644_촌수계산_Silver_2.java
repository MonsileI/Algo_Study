package Algorithmeighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_2644_촌수계산_Silver_2 {

    static List<List<Integer>> list;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int ans = bfs(s,e);
        System.out.println(ans);
    }
    static int bfs(int s,int e){
        Queue<int[]> q= new ArrayDeque<>();
        boolean[]visited= new boolean[N+1];
        visited[s] = true;
        q.offer(new int[]{s,0});
        while(!q.isEmpty()){
            int []c = q.poll();
            int now = c[0];
            int cnt = c[1];
            if(now==e)return cnt;
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        return -1;
    }
}
