package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_9466_텀프로젝트_Gold_3 {
    static boolean[]check;
    static boolean[]visited;
    static int[]arr;
    static int N;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st=  null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            //사이클 유무 파악 문제
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            arr =new int[N+1];
            for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());

            ans = 0;
            visited = new boolean[N+1];
            check = new boolean[N+1];
            for(int i=1;i<N+1;i++){
                dfs(i);
            }

            sb.append(N-ans+"\n");
        }

        System.out.println(sb.toString());
    }
    static void dfs(int node) {
        if(visited[node]) return;

        visited[node] = true;
        int next = arr[node];

        if(visited[next] != true)
            dfs(next);
        else {
            if(check[next] != true) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                ans++;
                for(int i=next; i != node; i = arr[i]) ans++;
            }
        }

        // 모든 작업이 끝나서 더이상 사용하지 않음
        check[node] = true;
    }
}
