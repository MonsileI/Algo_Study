package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_1931_회의실배정_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int answer= 0;
        int[][]room = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room,(o1 , o2) ->  o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int end = 0;
        for(int i=0;i<room.length;i++){
            if(end <= room[i][0]){
                end = room[i][1];
                answer++;
            }
        }


        System.out.println(answer);


    }
}
