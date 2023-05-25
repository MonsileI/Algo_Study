package May_Fourth.pr_;

import java.util.*;
public class pr_주식가격_Level_2 {

    public static void main(String[] args) {
        int [] prices = {1,2,3,2,3};
        int size = prices.length;
        int [] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmpStack = new Stack<>();
        for(int i=size-1;-1<i;i--){
            int num = prices[i];
            //처음에는 무조건 스택 채워주기(마지막값은 항상 0초)
            if(stack.isEmpty()){
                answer[i] = 0;
                stack.push(num);
            }else{
                int check = stack.peek();
                //넘버가 스택 최상위 값보다 크면, 바로 가격이 떨어진거니까 1 넣어주기
                if(check<num){
                    answer[i] = 1;
                    stack.push(num);
                }else{
                    while(true){
                        //스택이 비었으면 끝까지 가격이 내리지 않은거임
                        if(stack.isEmpty()){
                            answer[i] = tmpStack.size();
                            while(!tmpStack.isEmpty()){
                                int tmp = tmpStack.pop();
                                stack.push(tmp);
                            }
                            break;
                        //스택에서 숫자를 꺼내면서 비교
                        }else{
                            int tmp = stack.pop();
                            if(num<=tmp) tmpStack.push(tmp);
                            else{
                                answer[i] = tmpStack.size();
                                while(!tmpStack.isEmpty()){
                                    int tmp2 = tmpStack.pop();
                                    stack.push(tmp2);
                                }
                                break;
                            }
                        }

                    }
                    stack.push(num);
                }
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
