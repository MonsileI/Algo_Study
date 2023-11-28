package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_16947_서울지하철2호선_Gold_3 {
    static List<List<Integer>> list;
    static int N;
    static boolean flag;
    static boolean[]visited;
    static boolean[]check;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int[]answer = new int[N+1];
        check = new boolean[N+1];
        for(int i=1;i<N+1;i++) {
            flag = false;
            visited = new boolean[N+1];
             dfs(i,i,0);
            check[i] = flag;
        }
        for(int i=1;i<N+1;i++) {
            if(check[i]) continue;
            else answer[i] = bfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++)sb.append(answer[i]+" ");
        System.out.println(sb.toString());
    }
    static int bfs(int node){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{node,0});
        boolean[]visited= new boolean[N+1];
        visited[node] = true;
        while(!q.isEmpty()){
            int [] c = q.poll();
            int now = c[0]; int cnt = c[1];
            if(check[now]) return cnt;
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        return -1;
    }
    static void dfs(int root,int node,int cnt){
        if(flag) return;
        visited[node] = true;
        for(int next : list.get(node)){
            if(1<cnt){
                if(next==root) {
                    flag = true;
                    return;
                }
            }
            if(!visited[next]) dfs(root,next,cnt+1);
        }
        visited[node] = false;
    }
}
