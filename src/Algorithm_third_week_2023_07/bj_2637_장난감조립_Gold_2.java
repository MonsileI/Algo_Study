package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2637_장난감조립_Gold_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]price = new int[N+1][N+1];
        int[]node = new int[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            node[to]++;
            price[from][to] = weight;
        }
        Queue<int[]> q= new ArrayDeque<>();
        int base = 0;
        for(int i=1;i<N+1;i++){
            if(node[i]==0) {
                q.offer(new int[]{i,i,0});
                base++;
            }
        }

        int[]dist = new int[base];

        while(!q.isEmpty()){
            int[]c = q.poll();
            int now = c[0];
            int basic = c[1];
            int cost = c[2];

            if(now==N){
                dist[basic] = cost;
                continue;
            }

            for(int next : price[now]){
                node[next]--;
                if(node[next]==0){
                    q.offer(new int[]{next,basic,cost+price[now][next]});
                }
            }
        }
    }
}
