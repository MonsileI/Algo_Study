package Algorithm_eighth_week_2023_08.pr;

import java.util.Arrays;

public class pr_연속펄부분수열의합_Level_3 {
    public static void main(String[] args) {
        int[]sequence = {2, 3, -6, 1, 3, -1, 2, 4};

        int N = sequence.length;
        int[]tmpA = new int[N];
        int[]tmpB = new int[N];

        int idx = 1;
        for(int i=0;i<N;i++){
            tmpA[i] = sequence[i] * idx;
            idx *= -1;
            tmpB[i] = sequence[i] * idx;
        }
        int[]dp1 = new int[N];
        int[]dp2 = new int[N];
        dp1[0] = tmpA[0]; dp2[0] = tmpB[0];
        long max = 0;
        long answer = Math.max(dp1[0],dp2[0]);
        for(int i=1;i<N;i++){
            dp1[i] = Math.max(dp1[i-1]+tmpA[i],tmpA[i]);
            dp2[i] = Math.max(dp2[i-1]+tmpB[i],tmpB[i]);
            max = Math.max(dp1[i],dp2[i]);
            answer = Math.max(answer,max);
        }
        System.out.println(answer);


    }
}
