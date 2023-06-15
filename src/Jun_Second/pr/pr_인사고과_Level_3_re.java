package Jun_Second.pr;

import java.util.*;

public class pr_인사고과_Level_3_re {

    public static void main(String[] args) {

        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        int answer = 1;
        int size = scores.length;
        int []min = scores[0];
        int sum = min[0] + min[1];
        Arrays.sort(scores,(o1,o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : -(o1[0]-o2[0]));
        int max = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<size;i++){
            //탈락
            if(scores[i][1]<max){
                if(scores[i].equals(min)) {answer = -1; break;}
                scores[i][0] = -1;
                scores[i][1] = -1;
            }else{
                max = scores[i][1];
                list.add(scores[i][0]+scores[i][1]);
            }
        }
        if(answer!=-1) {
            size = list.size();
            for (int i = 0; i < size; i++) if (sum < list.get(i)) answer++;
        }
        System.out.println(answer);

    }
}