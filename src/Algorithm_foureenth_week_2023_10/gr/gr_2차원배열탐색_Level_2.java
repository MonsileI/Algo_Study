package Algorithm_foureenth_week_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_2차원배열탐색_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = 4;
        StringTokenizer st = null;
        int[][]map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
                answer = Math.max(answer,sum);
            }
        }
        System.out.println(answer);
    }
}
