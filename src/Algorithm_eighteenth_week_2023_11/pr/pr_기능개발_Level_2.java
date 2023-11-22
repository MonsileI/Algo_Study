package Algorithm_eighteenth_week_2023_11.pr;
import java.util.*;
public class pr_기능개발_Level_2 {
    public static void main(String[] args) {
        int[]progresses = {93, 30, 55};
        int[]speeds = {1, 30, 5};
        //며칠씩 걸리는지 먼저 계산
        int N = progresses.length;
        int[]arr = new int[N];
        for(int i=0;i<N;i++){
            int last = 100 - progresses[i];
            arr[i] = last/speeds[i];
            if(last%speeds[i]!=0) arr[i]++;
        }
        int before = arr[0];
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        for(int i=1;i<N;i++){
            if(arr[i]<=before) cnt++;
            else{
                list.add(cnt);
                cnt = 1;
                before = arr[i];
            }
        }
        list.add(cnt);
        System.out.println(list);
    }
}
