package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_11758_CCW_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] map = new int[3][2];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = (map[0][0]*map[1][1]
                       + map[1][0]*map[2][1]
                       + map[2][0]* map[0][1]);
        answer -= (map[0][1]*map[1][0]
                    + map[1][1] * map[2][0]
                    + map[2][1] * map[0][0]);

        if(answer!=0){
            if(answer>0) answer = 1;
            else answer = -1;
        }

        System.out.println(answer);
    }
}
