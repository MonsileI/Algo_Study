package Jun_Second;

import java.util.*;

public class pr_인사고과_Level_3 {

    public static void main(String[] args) {

        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        int answer = 0;
        int size = scores.length;
        int n = scores[0][0];
        int m = scores[0][1];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0])  return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        // 어차피 근무 태도는 내림차순으로 정렬되어 있으므로 동료 점수만 비교하면 됨
        int maxScore = scores[0][1];

        for(int i = 1; i<size; i++) {
            if (scores[i][1] < maxScore) { // 인센티브를 받지 못하는 경우
                if (scores[i][0] == n && scores[i][1] == m) {answer = -1; break;}//완호일 경우

                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                maxScore = scores[i][1];
            }
        }
        // Step 2
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        if(answer!=-1){
            answer = 1;
            // 완호보다 높은지만 체크하면 등수가 나온다
            for(int i = 0; i<size; i++) {
                if (scores[i][0] + scores[i][1] > n + m)  answer ++;
                else break;
            }
        }
        System.out.println(answer);
    }
}