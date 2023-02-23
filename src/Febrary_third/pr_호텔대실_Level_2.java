package Febrary_third;

import java.util.*;
import java.io.*;
public class pr_호텔대실_Level_2 {

    static int N,rooms[][];

    public static void main(String[] args) throws Exception {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},{"14:10", "19:20"}, {"18:20", "21:20"}};
        N = book_time.length;
        rooms = new int[N][2];

        for(int i=0;i<N;i++){

            String []tmp = book_time[i][0].split(":");
            //분은 그대로 더해줌                      //시간을 분으로 변환
            int start = Integer.parseInt(tmp[1]) + Integer.parseInt(tmp[0]) * 60;

            tmp = book_time[i][1].split(":");
            //분은 그대로 더해줌                      //시간을 분으로 변환
            int end = Integer.parseInt(tmp[1]) + Integer.parseInt(tmp[0]) * 60;

            rooms[i][0] = start;
            rooms[i][1] = end+10;

        }

        Arrays.sort(rooms,((o1, o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(rooms[0][1]);

        int answer = 0;

        for(int i=1;i<N;i++){
            if(pq.peek()<=rooms[i][0]) pq.poll();
            pq.offer(rooms[i][1]);
        }

        answer = pq.size();

        System.out.println(answer);


    }
}
