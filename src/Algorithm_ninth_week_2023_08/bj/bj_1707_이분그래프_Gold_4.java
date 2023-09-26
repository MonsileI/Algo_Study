package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1707_이분그래프_Gold_4 {

    static int[]visited;
    static int N;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new int[N+1];
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }
            boolean flag = true;
            for(int i=1;i<N+1;i++){
                if(visited[i]==0){
                    flag = check(i);
                    if(!flag) break;
                }
            }

            sb.append(flag ? "YES\n" : "NO\n");
        }
        System.out.println(sb.toString());
    }
    static boolean check(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list.get(now)){
                if(visited[now]==visited[next]) {
                    return false;
                }else if(visited[next]==0){
                    visited[next] = visited[now] * -1;
                    q.offer(next);
                    }
                }
            }

        return true;
    }
}
