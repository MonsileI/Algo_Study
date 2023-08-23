package Algorithm_third_week_2023_07;

import java.util.*;
public class pr_호텔대실_Level_2 {
    public static void main(String[] args) {
        String[][]book_time = {{"05:57", "06:02"}, {"04:00", "06:59"}, {"03:56", "07:57"}, {"06:12", "08:55"}, {"07:09", "07:11"}};
        int size = book_time.length;
        int[][]arr = new int[size][2];
        for(int i=0;i<size;i++){
            String start = book_time[i][0];
            String end = book_time[i][1];
            arr[i][0] = change(start);
            arr[i][1] = change(end);
        }

        Arrays.sort(arr,(o1,o2)->o1[0]==o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(arr[0][1]);
        for(int i=1;i<size;i++){
            int start = arr[i][0];
            if(start<q.peek()+10) q.offer(arr[i][1]);
            else {
                q.poll();
                q.offer(arr[i][1]);
            }

        }
        int answer = q.size();
        System.out.println(answer);

    }
    static int change(String time){
        String[]tmp = time.split(":");
        int result = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
        return result;
    }
}
