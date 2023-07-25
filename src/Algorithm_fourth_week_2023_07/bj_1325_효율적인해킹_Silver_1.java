package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1325_효율적인해킹_Silver_1 {
    static List<List<Integer>> list;
    static int N;
    static int[]result;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(to).add(from);
        }
        result = new int[N+1];
        for(int i=1;i<N+1;i++) bfs(i);

        StringBuilder sb = new StringBuilder();
        for(int i =1;i<N+1;i++){
            if(result[i]==max) sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int num){

        Queue<Integer> q = new ArrayDeque<>();
        boolean[]visited = new boolean[N+1];
        visited[num] = true;
        q.offer(num);
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
               for(int i : list.get(node)) {
                   if(!visited[i]) {
                       visited[i] = true;
                       cnt++;
                       q.offer(i);
                   }
                }
        }
        max = Math.max(max,cnt);
        result[num] = cnt;
    }
}
