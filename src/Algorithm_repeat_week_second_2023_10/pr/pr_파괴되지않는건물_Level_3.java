package Algorithm_repeat_week_second_2023_10.pr;

import java.util.*;

public class pr_파괴되지않는건물_Level_3 {
    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][]skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        int ans = 0;
        int size = skill.length;
        int[][]s = new int[board.length+1][board[0].length+1];
        for(int i=0;i<size;i++) {
            //1은 공격
            //2는 회복
            int diff = (skill[i][0]==1 ? -1 : 1);
            diff *= skill[i][5];
            int fi = skill[i][1]; int fj = skill[i][2];
            int si = skill[i][3]; int sj = skill[i][4];
            s[fi][fj] += diff;
            s[fi][sj+1] -= diff;
            s[si+1][fj] -= diff;
            s[si+1][sj+1] += diff;
        }
        int N = board.length;
        int M = board[0].length;
        for(int j=0;j<M;j++){
            int sum = 0;
            for(int i=0;i<N;i++){
                sum += s[i][j];
                s[i][j] = sum;
            }
        }
        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<M;j++){
                sum += s[i][j];
                s[i][j] = sum;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<board[i][j]+s[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }
}
