package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1389_케빈베이컨의6단계법칙_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j) map[i][j] = 0;
                else map[i][j] = 987654321;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = 1;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(map[i][j] > map[i][l]+map[l][j]){
                        map[i][j] = map[i][l]+map[l][j];
                    }
                }
            }
        }
        int answer = 987654321;
        int num = 0;
        for(int i=1;i<N+1;i++){
            int cnt = 0;
            for(int j=1;j<N+1;j++){
                cnt+= map[i][j];
            }
            if(cnt<answer){
                answer = cnt;
                num = i;
            }
        }
        System.out.println(num);
    }
}
