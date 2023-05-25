package May_Fourth.pr_;

import java.util.*;

public class pr_택배상자_Level_2 {

    public static void main(String[] args) {
        int[]order = {4, 3, 1, 2, 5};
        Stack<Integer> stack = new Stack<>();
        int op = 0; //order의 포인터
        int currentBox = 1; //컨베이어벨트 위의 포인터
        int answer=0;

        while(op<order.length){

            if(order[op]> currentBox){
                stack.push(currentBox);
                currentBox++;
            }else if(currentBox==order[op]){
                currentBox++;
                answer++;
                op++;
            }else{

                while(!stack.isEmpty() && order[op] == stack.peek()){
                    stack.pop();
                    answer++;
                    op++;
                }
                if (op >= order.length || order[op] < currentBox) break;
            }
        }

        System.out.println(answer);
    }
}
