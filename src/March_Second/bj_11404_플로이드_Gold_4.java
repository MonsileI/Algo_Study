package March_Second;

import java.util.*;
import java.io.*;
public class bj_11404_플로이드_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][]dist = new int[N+1][N+1];

        int DIF = 987654321;

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j) dist[i][j] = 0;
                else dist[i][j] = DIF;
            }
        }
        StringTokenizer st = null;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(dist[from][to],weight);

        }

        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    dist[i][j] = Math.min(dist[i][j],dist[i][l] + dist[l][j]);
                }
            }
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(dist[i][j]==DIF) dist[i][j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                sb.append(dist[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
