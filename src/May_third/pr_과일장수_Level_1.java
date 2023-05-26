package May_third;

import java.util.Arrays;

public class pr_과일장수_Level_1 {
    public static void main(String[] args) {
        int k =3;   int m =4; int[]score = {1, 2, 3, 1, 2, 3, 1};
        Arrays.sort(score);
        int answer = 0;
        int idx = score.length-1;
        while(true){
                if(idx-m+1<0) break;
                answer += score[idx-m+1]*m;
                idx -= m;
        }
        System.out.println(answer);


    }
}
