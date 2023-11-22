package Algorithm_eighteenth_week_2023_11.복습;
import java.util.*;
public class pr_파괴되지않은건물_Level_3 {

    static int solution(int[][] board, int[][] skill) {
        int N = board.length; int M = board[0].length;
        int[][]dp = new int[N+1][M+1];
        for(int i=0;i< skill.length;i++){
            int diff = skill[i][5];
            if(skill[i][0]==1) diff *= -1;
            int fi = skill[i][1];
            int fj = skill[i][2];
            int si = skill[i][3];
            int sj = skill[i][4];
            dp[fi][fj] += diff;
            dp[si+1][fj] -= diff;
            dp[fi][sj+1] -= diff;
            dp[si+1][sj+1] += diff;
        }
        //가로
        for(int i=0;i<N+1;i++){
            int sum = 0;
            for(int j=0;j<M+1;j++){
                sum += dp[i][j];
                dp[i][j] = sum;
            }
        }
        //세로
        for(int j=0;j<M;j++){
            int sum = 0;
            for(int i=0;i<N;i++){
                sum += dp[i][j];
                dp[i][j] = sum;
            }
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<board[i][j]+dp[i][j]) answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][]board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][]skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        System.out.println(solution(board,skill));
    }
}
