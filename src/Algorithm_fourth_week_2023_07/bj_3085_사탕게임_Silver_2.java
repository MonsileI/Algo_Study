package Algorithm_fourth_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_3085_사탕게임_Silver_2 {
    static int N;
    static char[][]map;
    static int answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();

        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                char tmp = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = tmp;
                check();
                map[i][j+1] = map[i][j];
                map[i][j] = tmp;
            }
        }
        for(int j=0;j<N;j++){
            for(int i=0;i<N-1;i++){
                char tmp = map[i][j];
                map[i][j] = map[i+1][j];
                map[i+1][j] = tmp;
                check();
                map[i+1][j] = map[i][j];
                map[i][j] = tmp;
            }
        }
        System.out.println(answer);
    }

    static void check(){

        for(int i=0;i<N;i++){
            int cnt =1;
            for(int j=0;j<N-1;j++){
                if(map[i][j]==map[i][j+1]){
                    cnt++;
                    answer = Math.max(answer,cnt);
                }
                else cnt = 1;

            }
        }
        for(int j=0;j<N;j++){
            int cnt =1;
            for(int i=0;i<N-1;i++){
                if(map[i][j]==map[i+1][j]) {
                    cnt++;
                    answer = Math.max(answer,cnt);
                }else cnt = 1;

            }
        }

    }

}
