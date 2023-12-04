package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1697_숨바꼭질_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[]dist = new int[100001];
        int INF = 987654321;
        Arrays.fill(dist,INF);
        dist[a] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{a,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int now = c[0]; int cnt = c[1];
            dist[now] = cnt;
            if(now==b) break;
            int newOne = now+1;
            if(newOne<100001)if(dist[newOne]==INF) q.offer(new int[]{newOne,cnt+1});
            newOne = now*2;
            if(newOne<100001)if(dist[newOne]==INF) q.offer(new int[]{newOne,cnt+1});
            newOne = now-1;
            if(newOne>-1)if(dist[newOne]==INF) q.offer(new int[]{newOne,cnt+1});
        }
        System.out.println(dist[b]);
    }
}
