package Algorithm_third_week_2023_07;

import java.io.*;
import java.util.*;
public class bj_16918_봄버맨_Silver_1 {
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M,T;
    static char[][]map;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }


    }
}
