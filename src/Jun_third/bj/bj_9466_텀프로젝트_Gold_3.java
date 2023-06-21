package Jun_third.bj;

import java.util.*;
import java.io.*;
public class bj_9466_텀프로젝트_Gold_3 {

    static int N,arr[],answer;
    static boolean[]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            answer = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            for(int i=1;i<N+1;i++)bfs(i);
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void bfs(int num){

        if(visited[num]) return;

        visited = new boolean[N+1];

        boolean flag = false;

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(arr[num]);

        visited[num] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur==num) {
                flag = true;
                break;
            }
            if(!visited[cur]){
                visited[cur] = true;
                q.offer(arr[cur]);
            }
        }
        if(!flag) answer++;

    }

}
