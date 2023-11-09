package Algorithm_seventeenth_week_2023_11.복습;

import java.util.Arrays;

public class pr_파괴되지않은건물_Level_3 {
    public static void main(String[] args) {
        int[][]board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][]skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        int N = board.length;
        int M = board[0].length;
        int[][]change = new int[N+1][M+1];
        for(int i=0;i<skill.length;i++){
            int act = skill[i][0];
            int ect = skill[i][5];
            if(act==1) ect *= -1;
            int fi = skill[i][1]; int fj = skill[i][2]; int si = skill[i][3]; int sj = skill[i][4];
            change[fi][fj] += ect;
            change[fi][sj+1] -= ect;
            change[si+1][fj] -= ect;
            change[si+1][sj+1] += ect;
        }

        int ans = 0;


        //가로
        for(int i=0;i<N+1;i++){
            for(int j=0;j<M;j++){
                change[i][j+1] += change[i][j];
            }
        }
        //세로
        for(int j=0;j<M+1;j++){
            for(int i=0;i<N;i++){
                change[i+1][j] += change[i][j];
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]+change[i][j]>0) ans++;
            }
        }
        System.out.println(ans);
    }
}
