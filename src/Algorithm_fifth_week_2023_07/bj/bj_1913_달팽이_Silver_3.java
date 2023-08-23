package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_1913_달팽이_Silver_3 {
    static int[][]move = {{1,0},{0,1},{-1,0},{0,-1}}; //하 우 상 좌
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][]map = new int[N][N];
        int num = N*N;
        int i =0; int j=0;
        int dir =0;
        map[0][0] = N*N;
        while(true){
            int ni = i + move[dir][0]; int nj = j + move[dir][1];
            if(ni<0||nj<0||N-1<ni||N-1<nj||map[ni][nj]!=0){
                dir = (dir+1)%4;
            }else{
                map[ni][nj] = --num;
                i = ni; j = nj;
            }
            if(num==1) break;
        }
        StringBuilder sb = new StringBuilder();
        int ti = 0; int tj = 0;
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                sb.append(map[y][x]+" ");
                if(map[y][x]==target) {ti = y+1 ; tj = x+1;}
            }
            sb.append("\n");
        }
        sb.append(ti+ " "+tj);
        System.out.println(sb.toString());


    }
}
