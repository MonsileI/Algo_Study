package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_17144_미세먼지안녕_Gold_4 {
    static int N,M,T;
    static int [][]map;
    static int dfi,dsi;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1){
                    dfi = i-1; dsi = i;
                }
            }
        }

        while(0<T){
            T--;
            //미세먼지 확산
            dust();
            //공기청정기 가동!!
            clean();
        }
        int ans = 0;
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) if(0<map[i][j]) ans += map[i][j];
        System.out.println(ans);
    }
    static void clean(){

        //위에꺼
        map[dfi-1][0] = 0; //젤 가까운애 공기청정기에 쏘옥
        //위에서 아래
        for(int i=dfi-1;0<i;i--) map[i][0] = map[i-1][0];
        //오른쪽에서 왼쪽
        for(int j=0;j<M-1;j++) map[0][j] = map[0][j+1];
        //아래에서 위
        for(int i=0;i<dfi;i++) map[i][M-1] = map[i+1][M-1];
        //왼쪽에서 오른쪽
        for(int j=M-1;1<j;j--) map[dfi][j] = map[dfi][j-1];
        map[dfi][1] = 0;


        //아래꺼
        map[dsi+1][0] = 0;
        //아래에서 위
        for(int i=dsi+1;i<N-1;i++) map[i][0] = map[i+1][0];

        //오른쪽에서 왼쪽
        for(int j=0;j<M-1;j++) map[N-1][j] = map[N-1][j+1];
        //위에서 아래
        for(int i=N-1;dsi<i;i--) map[i][M-1] = map[i-1][M-1];
        //왼쪽에서 오른쪽
        for(int j=M-1;1<j;j--) map[dsi][j] = map[dsi][j-1];
        map[dsi][1] = 0;
    }

    static void dust(){
        int[][]tmp = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tmp[i][j] = map[i][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<map[i][j]){
                    int sum=0;
                    for(int d=0;d<4;d++){
                        int ni = i +move[d][0]; int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(map[ni][nj]==-1) continue;
                        tmp[ni][nj] += map[i][j]/5;
                        sum += map[i][j]/5;
                    }
                    tmp[i][j] -= sum;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = tmp[i][j];
            }
        }

    }
}
