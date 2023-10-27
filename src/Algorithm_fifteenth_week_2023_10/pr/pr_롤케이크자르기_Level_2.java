package Algorithm_fifteenth_week_2023_10.pr;

import java.util.*;
public class pr_롤케이크자르기_Level_2 {
    public static void main(String[] args) {
        int[]topping = {1, 2, 3, 1, 4};
        int N = topping.length;
        boolean[]visitedL = new boolean[10001];
        boolean[]visitedR = new boolean[10001];
        int[]left = new int[N];
        int[]right = new int[N];
        left[0] = 1;
        right[N-1] = 1;
        visitedL[topping[0]] = true;
        visitedR[topping[N-1]] = true;
        for(int i=1;i<N;i++){
            if(!visitedL[topping[i]]){
                visitedL[topping[i]] = true;
                left[i]++;
            }
            if(!visitedR[topping[N-i-1]]){
                visitedR[topping[N-i-1]] = true;
                right[N-i-1]++;
            }
            left[i] += left[i-1];
            right[N-i-1] += right[N-i];
        }
        int answer = 0;
        for(int i=0;i<N-1;i++){
            if(left[i]==right[i+1])answer++;
        }
        System.out.println(answer);
    }
}
