package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_11404_플로이드_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][]map = new int[N+1][N+1];
        int INF = 987654321;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                map[i][j] = INF;
            }
        }
        StringTokenizer st = null;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b],w);
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    map[i][j] = Math.min(map[i][j],map[i][l]+map[l][j]);
                }
            }
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(map[i][j]==INF) map[i][j] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
