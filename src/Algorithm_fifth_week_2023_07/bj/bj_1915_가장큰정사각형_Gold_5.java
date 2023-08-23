package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_1915_가장큰정사각형_Gold_5 {
    static int N, M, map[][];
    static int answer;

    static int[][] sumMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        sumMap = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            String str = br.readLine();
            for (int j = 1; j < M+1; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j-1) + "");
            }
        }
        for (int i = 1; i < N+1; i++) {
            for(int j=1;j<M+1;j++){
                sumMap[i][j] = sumMap[i-1][j]+sumMap[i][j-1]-sumMap[i-1][j-1]+map[i][j];
            }
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]==1){
                    int next = 1;
                    int board = 4;
                    int result = board;
                    while(true){
                        result = board;
                        int ni = i + next; int nj = j + next;
                        if(result==9) System.out.println(i+" : "+j+" : "+ni+" : "+nj);
                        if(ni<0||nj<0||N-1<ni||M-1<nj) break;
                        next++;
                        board = (next+1)*(next+1);
                        int point = sumMap[ni][nj] - sumMap[ni][j]-sumMap[i][nj] - sumMap[ni][nj];
                        if(point!=board) break;
                    }

                    answer = Math.max(answer,result);
                }
            }
        }
        System.out.println(answer);
    }
}