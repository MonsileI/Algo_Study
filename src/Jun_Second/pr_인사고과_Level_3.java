package Jun_Second;

import java.util.*;

public class pr_인사고과_Level_3 {

    public static void main(String[] args) {

        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        int[] wanHo = scores[0];
        // 근무태도점수 내림차순정렬. 근무태도 동점인 경우 동료평가점수 오름차순
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        ArrayList<Integer> ranking = new ArrayList<>();

        int maxScore = 0;
        for (int[] score : scores) {
            // 내 앞에 동료평가점수가 나보다 높은사람이 한명이라도 있으면 탈락
            // 근무태도 동점자의 경우 동료평가 오름차순 하였으므로 고려하지 않아도 됨
            if (score[1] < maxScore) {
                // 탈락대상
                if (score.equals(wanHo))
                    continue;
            } else {
                // 인센대상
                ranking.add(score[0] + score[1]);
                maxScore = Math.max(maxScore, score[1]);
            }
        }

        // 총점 내림차순 정렬. 1-index로 사용하기 위해 총점 최대값보다 높은 200001삽입
        ranking.add(200001);
        ranking.sort((a, b) -> b - a);
        System.out.println(ranking.indexOf(wanHo[0] + wanHo[1]));
    }
}
