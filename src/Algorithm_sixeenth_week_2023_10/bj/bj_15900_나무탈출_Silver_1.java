package Algorithm_sixeenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_15900_나무탈출_Silver_1 {
    static int N;
    static List<List<Integer>> list;
    static int cnt;
    static boolean[]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        StringTokenizer st = null;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[N+1];
        dfs(1,visited,0);
        if(cnt%2==0) System.out.println("No");
        else System.out.println("Yes");
    }
    static void dfs(int node,boolean[]visited,int depth){
        visited[node] = true;
        for(int next : list.get(node)){
            if(!visited[next]){
                dfs(next,visited,depth+1);
            }
        }
        if (node != 1 && list.get(node).size() == 1) {
            cnt += depth;
        }
    }
}
