package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_11000_강의실배정_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int [][] room = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room,((o1, o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue();

        pq.offer(room[0][1]);
        int answer = 0;
        for(int i=1;i<N;i++){
            if(pq.peek() <= room[i][0]) pq.poll();
            pq.offer(room[i][1]);
        }
        answer = pq.size();
        System.out.println(answer);
    }
}
