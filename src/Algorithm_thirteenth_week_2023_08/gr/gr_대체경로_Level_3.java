package Algorithm_thirteenth_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_대체경로_Level_3 {
    static List<List<Integer>> list;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        for(int i=1;i<N+1;i++){
            if(i==s||i==e)  sb.append(-1+"\n");
            else{
                sb.append(bfs(s,e,i)+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int bfs(int s,int e,int x){

        int[]dist = new int[N+1];
        boolean[]visited = new boolean[N+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{s,1});
        while(!q.isEmpty()){
            int []c = q.poll();
            int now = c[0]; int cnt = c[1];
            if(now==e) return cnt;
            for(int next : list.get(now)){
                if(next==x) continue;
                if(!visited[next]){
                    visited[next]= true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }

        return -1;
    }
}
