package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_14500_테트로미노_Gold_4 {
    static int N,M,map[][];
    //첫번째꺼 길쭉이
  /*  static int [][] f = {{0,0},{0,1},{0,2},{0,3}};
    static int [][] ff = {{0,0},{1,0},{2,0},{3,0}};

    //두번째꺼 네모
    static int [][] s = {{0,0},{1,0},{0,1},{1,1}};

    //세번째 니은

    static int [][] t = {{0,0},{1,0},{2,0},{2,1}};
    static int [][] tt = {{0,0},{1,0},{2,0},{2,-1}};

    static int [][] ttt = {{0,0},{0,-1},{0,-2},{1,-2}};
    static int [][] tttt = {{0,0},{0,1},{0,2},{1,2}};

    //네번째 리을
    static int [][] fo = {{0,0},{1,0},{1,1},{2,1}};
    static int [][] ffo = {{0,0},{1,0},{-1,-1},{-2,-1}};
    static int [][] fffo = {{0,0},{0,-1},{-1,-1},{-1,-2}};
    static int [][] ffffo = {{0,0},{0,1},{1,1},{2,1}};

    //다섯번째 티
    static int [][]fi = {{0,0},{0,1},{1,1},{2,0}};
    static int [][]ffi = {0,0},{0,1},{-1,1},{2,0}};
    static int [][]fffi = {{0,0},{1,0},{2,0},{1,1}};
    static int [][]ffffi = {{0,0},{1,0},{2,0},{-1,-1}};*/

    static int [][] move = {{0,0},{0,1},{0,2},{0,3},
                            {0,0},{1,0},{2,0},{3,0},

                            {0,0},{1,0},{0,1},{1,1},

                            {0,0},{1,0},{2,0},{2,1},
                            {0,0},{1,0},{2,0},{2,-1},
                            {0,0},{0,-1},{0,-2},{1,-2},
                            {0,0},{0,1},{1,1},{2,1},

                            {0,0},{1,0},{1,1},{2,1},
                            {0,0},{1,0},{-1,-1},{-2,-1},
                            {0,0},{0,-1},{-1,-1},{-1,-2},
                            {0,0},{0,1},{1,1},{1,2},

                            {0,0},{0,1},{1,1},{2,0},
                            {0,0},{0,1},{-1,1},{2,0},
                            {0,0},{1,0},{2,0},{1,1},
                            {0,0},{1,0},{2,0},{-1,-1}};



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<56;k+=4) {
                    int sum = 0;
                    for (int d = k; d < k+4; d++) {
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) {
                            sum = 0;
                            break;
                        }
                        sum += map[ni][nj];
                    }
                    answer = Math.max(answer, sum);
                    sum = 0;
                }
            }
        }
        System.out.println(answer);
    }
}
