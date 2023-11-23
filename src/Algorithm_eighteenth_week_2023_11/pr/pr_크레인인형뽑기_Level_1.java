package Algorithm_eighteenth_week_2023_11.pr;

import java.util.Arrays;
import java.util.Stack;

public class pr_크레인인형뽑기_Level_1 {
    static int solution(int[][] board, int[] moves) {

        //위에서부터 주어짐
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int N = board.length;
        for(int t=0;t<moves.length;t++){
            int move = moves[t]-1;
            InnerLoop:
            for(int i=0;i<N;i++){
                if(board[i][move]!=0){
                    if(!stack.isEmpty()&&stack.peek()==board[i][move]){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(board[i][move]);
                    }
                    board[i][move] = 0;
                    break InnerLoop;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][]board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[]moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
}
