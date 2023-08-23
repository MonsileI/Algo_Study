package Algorithm_seventh_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_단풍나무_Level_3 {
    static int N;
    static int[][]map;
    static int[][]tmp;
    static boolean flag;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int sum = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0)sum++;
            }
        }
        if(sum==N*N) System.out.println(0);
        else{
            int day = 0;
            while(true){
                calc();
                check();
                day++;
                if(flag) break;
            }
            System.out.println(day);
        }
    }
    static void check(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0) return;
            }
        }
        flag = true;
    }
    static void calc(){
        tmp = new int[N][N];
        //map 복사
        for(int i=0;i<N;i++)for(int j=0;j<N;j++)tmp[i][j] = map[i][j];
        int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
        // 계산
        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
                if(tmp[i][j]!=0){
                    InnerLoop:
                    for(int d=0;d<4;d++){
                        int ni = i + dir[d][0]; int nj = j + dir[d][1];
                        if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                        if(map[ni][nj]==0){
                            tmp[i][j]--;
                            if(tmp[i][j]<0) {
                                tmp[i][j] = 0;
                                break InnerLoop;
                            }
                        }
                    }
                }
            }
        }
        //map에 tmp복사
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) map[i][j] = tmp[i][j];
    }
}
