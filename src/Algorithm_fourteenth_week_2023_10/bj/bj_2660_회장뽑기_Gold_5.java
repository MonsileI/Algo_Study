package Algorithm_fourteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2660_회장뽑기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]dist = new int[N+1][N+1];
        StringTokenizer st = null;
        int INF = 987654321;
        for(int i=1;i<N+1;i++) for(int j=1;j<N+1;j++) dist[i][j] = INF;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(from==-1&&to==-1) break;
            dist[from][to] = 1;
            dist[to][from] = 1;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    dist[i][j] = Math.min(dist[i][j],dist[i][l]+dist[l][j]);
                }
            }
        }
        int[]minArr = new int[N+1];
        int min = 987654321;
        for(int i=1;i<N+1;i++){
            int max = 0;
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                max = Math.max(max,dist[i][j]);
            }
            minArr[i] = max;
            min = Math.min(max,min);
        }
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(min==minArr[i]) {
                list.add(i);
                cnt++;
            }
        }
        sb.append(min+" "+cnt+"\n");
        for(int i : list) sb.append(i+" ");
        System.out.println(sb.toString());
    }

}
