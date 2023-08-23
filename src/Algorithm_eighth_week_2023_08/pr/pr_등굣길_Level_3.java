package Algorithm_eighth_week_2023_08.pr;

import java.util.Arrays;

public class pr_등굣길_Level_3 {

    public static void main(String[] args) {
        int m = 4; int n = 3;
        int[][]puddles = {{2,2}};
        int N = n;
        int M = m;
        int[][]map = new int[N+1][M+1];
        int size = puddles.length;

        for(int i=0;i<size;i++) map[puddles[i][1]][puddles[i][0]] = -1;

        map[1][1] = 1;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]==-1) continue;
                if(map[i-1][j]>0) map[i][j] += (map[i-1][j]%1000000007);
                if(map[i][j-1]>0) map[i][j] += (map[i][j-1]%1000000007);
            }
        }
        System.out.println(map[N][M]%1000000007);

    }
}
