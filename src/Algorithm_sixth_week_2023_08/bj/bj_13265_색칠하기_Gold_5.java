package Algorithm_sixth_week_2023_08.bj;

import java.io.*;
import java.util.*;

public class bj_13265_색칠하기_Gold_5 {

    static boolean []visited;
    static int N;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            visited = new boolean[N+1];
            boolean[]superVisited = new boolean[N+1];
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st  = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to); list.get(to).add(from);
                superVisited[from] = true;
                superVisited[to] = true;
            }
            int cnt = 0;
            boolean flag = true;
            for(int i=1;i<N+1;i++) {
                if(!superVisited[i])cnt++;
                if(3<cnt) {
                    sb.append("impossible"+"\n");
                    flag= false;
                    break;
                }
            }
            if(!flag) continue;
            visited[1] = true;
            for(int i=1;i<N+1;i++) {
                if(!bfs(i)){
                    sb.append("impossible"+"\n");
                    flag = false;
                    break;
                }
            }
            if(flag) sb.append("possible"+"\n");

        }
        System.out.println(sb.toString());
    }
    static boolean bfs(int num){

        boolean[]tmp = new boolean[N+1];
        tmp[num] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(num);

        while(!q.isEmpty()){
            int c = q.poll();
            for(int i : list.get(c)){
                if(!tmp[i]){
                    tmp[i] = true;
                    visited[i] = !visited[c];
                    q.offer(i);
                }else{
                    if(visited[c]==visited[i]) return false;
                }
            }
        }
        return true;
    }
}
