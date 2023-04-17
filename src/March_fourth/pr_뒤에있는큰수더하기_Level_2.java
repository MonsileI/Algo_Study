package March_fourth;


import java.util.*;

public class pr_뒤에있는큰수더하기_Level_2 {
    public static void main(String[] args) throws Exception {
        int [] numbers = {2,3,3,5};
        int [] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for(int i=1;i<numbers.length;i++){
            int num = numbers[i];
            while(!stack.isEmpty() && numbers[stack.peek()] < num){
                result[stack.pop()] = num;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }


        System.out.println(Arrays.toString(result));



    }
}
