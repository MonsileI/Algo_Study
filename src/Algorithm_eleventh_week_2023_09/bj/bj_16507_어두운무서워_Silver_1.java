package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_16507_어두운무서워_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int [][]map = new int[N][M];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][]cArr = new int[C][2];


    }
}
