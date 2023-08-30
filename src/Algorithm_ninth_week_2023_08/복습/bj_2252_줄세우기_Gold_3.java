package Algorithm_ninth_week_2023_08.복습;

import java.util.*;
import java.io.*;
public class bj_2252_줄세우기_Gold_3 {
    static int N;
    static int[]dist;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            dist[to]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<N+1;i++) if(dist[i]==0) q.offer(i);
        StringBuilder sb= new StringBuilder();

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int next : list.get(now)){
                dist[next]--;
                if(dist[next]==0){
                    q.offer(next);
                }
            }
        }

        System.out.println(sb.toString());



    }
}
