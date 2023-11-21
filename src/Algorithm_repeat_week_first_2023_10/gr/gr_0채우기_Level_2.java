package Algorithm_repeat_week_first_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_0채우기_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]map = new int[N][N];
        int zi = 0; int zj = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    zi = i; zj = j;
                }
            }
        }
        int answer = 0;
        for(int i=0;i<N;i++) answer += map[i][zj];
        for(int j=0;j<N;j++) answer += map[zi][j];
        System.out.println(answer);
    }
}
