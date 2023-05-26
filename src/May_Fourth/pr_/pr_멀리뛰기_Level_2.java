package May_Fourth.pr_;

import java.util.Arrays;

public class pr_멀리뛰기_Level_2 {
    public static void main(String[] args) {
        int n = 5;
        long [] arr = new long[20];
        long answer = 0;
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        if(n<=2) answer = arr[n];
        else{
            for(int i=3;i<=n;i++){
                arr[i] = (arr[i-1] + arr[i-2])%1234567;
            }
        }

        answer = arr[n];
        System.out.println(answer);
    }
}
