package Algorithm_foureenth_week_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_폭탄게임2_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][]oMap = new char[N][N];
        int[][] map = new int[N][N];
        for(int i=0;i<N;i++){
            String[]tmp = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                oMap[i][j] = tmp[j].charAt(0);
            }
        }
        int[][]dir = {{-1,0},{0,1},{1,0},{0,-1},{0,0}};

        for(int t=0;t<M;t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            for(int d=0;d<5;d++){
                int ni = i + dir[d][0];
                int nj = j + dir[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(oMap[ni][nj]=='#') continue;
                if(oMap[ni][nj]=='@') map[ni][nj] += 2;
                else map[ni][nj]++;
            }
        }
        int answer = 0;
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) answer = Math.max(answer,map[i][j]);
        System.out.println(answer);
    }
}
