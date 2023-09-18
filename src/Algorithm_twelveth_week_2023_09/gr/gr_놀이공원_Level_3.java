package Algorithm_twelveth_week_2023_09.gr;

import java.util.*;
import java.io.*;

public class gr_놀이공원_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int answer = 987654321;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][]map = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N-M+1;i++){
                for(int j=0;j<N-M+1;j++){
                    int sum = 0;
                    for(int k=i;k<i+M;k++){
                        for(int l=j;l<j+M;l++){
                            sum += map[k][l];
                        }
                    }
                    answer = Math.min(answer,sum);
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
}

