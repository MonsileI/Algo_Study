package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1697_숨바꼭질_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]dist = new int[100001];
        //-1 +1 *2
        int INF = 987654321;
        Arrays.fill(dist,INF);
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist[s] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{s,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int now = c[0]; int cnt = c[1];
            dist[now] = cnt;
            if(now==e) break;
            int next = now;
                //+1 *2
                next++;
                if(next<100001)if(dist[next]==INF) q.offer(new int[]{next,cnt+1});
                next--;
                next *= 2;
                if(next<100001) if(dist[next]==INF) q.offer(new int[]{next,cnt+1});
                //-1
                next /= 2;
                next--;
                if(-1<next) if(dist[next]==INF) q.offer(new int[]{next,cnt+1});
        }
        System.out.println(dist[e]);
    }
}
