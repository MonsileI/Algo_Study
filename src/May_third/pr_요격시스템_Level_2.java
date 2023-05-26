package May_third;


import java.util.Arrays;

public class pr_요격시스템_Level_2 {

    public static void main(String[] args) {
        int[][]targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int last = targets[0][1];
        answer++;
        int size = targets.length;

        for(int [] i : targets) System.out.println(Arrays.toString(i));

        for(int i=1;i<size;i++){

            int thisStart = targets[i][0];
            int thisEnd = targets[i][1];

            if(thisStart < last) continue;
            else{
                last = thisEnd;
                answer++;
            }

        }

        System.out.println(answer);

    }
}
