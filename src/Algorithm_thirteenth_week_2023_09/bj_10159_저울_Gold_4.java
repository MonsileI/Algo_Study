package Algorithm_thirteenth_week_2023_09;

import java.util.*;
import java.io.*;
public class bj_10159_저울_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][]pw = new boolean[N+1][N+1];
        boolean[][]rpw = new boolean[N+1][N+1];
        StringTokenizer st = null;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pw[a][b] = true;
            rpw[b][a] = true;
        }
        for(int l=1;l<N+1;l++){
            for(int i =1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if(pw[i][l] &&pw[l][j]) pw[i][j] = true;
                    if(rpw[i][l]&&rpw[l][j]) rpw[i][j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            int cnt = 0;
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                if(!pw[i][j] && !rpw[i][j]) cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb.toString());
    }
}
