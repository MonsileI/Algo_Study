package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14567_선수과목_Gold_5 {

    static int N;

    static Queue<int[]> q;
    static int[]dist;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        dist = new int[N+1];
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            dist[second]++;
            list.get(first).add(second);
        }
        q = new ArrayDeque<>();
        int[]ans = new int[N+1];
        for(int i=1;i<N+1;i++){
            if(dist[i]==0){
                q.offer(new int[]{i,1});
                ans[i] = 1;
            }
        }
        while(!q.isEmpty()){
            int[]c = q.poll();
            int node = c[0]; int cnt = c[1];
            ans[node] = cnt;
            for(int next : list.get(node)){
                dist[next]--;
                if(dist[next]==0){
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) sb.append(ans[i]+" ");
        System.out.println(sb.toString());

    }
}
