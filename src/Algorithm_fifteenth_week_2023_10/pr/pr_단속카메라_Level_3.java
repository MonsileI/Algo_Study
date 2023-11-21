package Algorithm_fifteenth_week_2023_10.pr;
import java.util.*;
public class pr_단속카메라_Level_3 {
    public static void main(String[] args) {
        int[][]routes = {{-20,-15},{-14,-5},{-18,-13 },{-5,-3}};
        Arrays.sort(routes,(o1,o2)->o1[1]==o2[1] ? o1[0]-o2[0] : o1[1] - o2[1]);
        int end = routes[0][1];
        int N = routes.length;
        int answer = N;
        for(int i=1;i<N;i++){
            if(end>=routes[i][0]) answer--;
            else end = routes[i][1];
        }
        System.out.println(answer);
    }
}
