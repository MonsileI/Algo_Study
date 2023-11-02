package Algorithm_sixeenth_week_2023_10.복습;
import java.util.*;
import java.io.*;
public class bj_2644_촌수계산_Silver_2 {
    static int N;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);

        }
        int answer = bfs(f,s);
        System.out.println(answer==0 ? -1 : answer);
    }
    static int bfs(int f,int s){
        boolean[]visited = new boolean[N+1];
        visited[f] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{f,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int now = c[0]; int cnt = c[1];
            if(now==s) return cnt;
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
    return 0;
    }
}
