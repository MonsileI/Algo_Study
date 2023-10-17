package Algorithm_repeat_week_second_2023_10.pr;

import java.util.*;

public class pr_숫자게임_Level_3 {
    public static void main(String[] args) {
        int [] A = {5,1,3,7};
        int [] B = {2,2,6,8};
        Arrays.sort(B);
        Arrays.sort(A);
        int N = A.length;
        int idx = N-1;

        int score = 0;
        for(int i=N-1;-1<i;i--){
            if(B[idx]>A[i]){
                score++;
                idx--;
            }
        }
        System.out.println(score);
    }
}
