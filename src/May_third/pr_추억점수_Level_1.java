package May_third;

import java.util.*;

public class pr_추억점수_Level_1 {
    public static void main(String[] args) {
        String[]name = {"may", "kein", "kain", "radi"};
        int[]yearning = {5,10,1,3};
        String[][]photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        Map<String, Integer> map = new HashMap<>();
        int size = name.length;
        for(int i=0;i<size;i++){
            String n = name[i];
            int score = yearning[i];
            map.put(n,score);
        }

        int[]answer = new int[photo.length];
        size = photo.length;
        for(int i=0;i<size;i++){
            int s = photo[i].length;
            int sum = 0;
            for(int j=0;j<s;j++){
                String n = photo[i][j];
                if(map.containsKey(n))  sum += map.get(n);
            }
            answer[i] = sum;
        }
        System.out.println(answer);
    }
}
