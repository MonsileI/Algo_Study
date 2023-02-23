package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_14503_로봇청소기_Gold_5 {

    static int N,M;
    static int map[][];
    static int rd,ri,rj;
    static int answer = 0;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};

    static  boolean flag = false; //네 방향 확인 flag
    /*
    d 방향 0 1 2 3 상 우 하 좌
    0 == 청소안됨
    1 == 벽
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine()," ");
        ri = Integer.parseInt(st.nextToken());
        rj = Integer.parseInt(st.nextToken());
        rd = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //===============여기까지 인 풋==============================

        while(true){
            //1단계 현재칸이 청소되지 않으면 청소
            if(map[ri][rj]==0) {
                map[ri][rj]= 2;
                answer++;
            }
            //2단계 네 방향 확인
            flag = check();

            if(flag){
            //3_1 청소할 곳이 있는 경우 ( 할거 하고 1번으로 ㄱ )
                rd = (rd+3)%4; //반시계방향으로 돌앗!
                int ni = ri + move[rd][0];
                int nj = rj + move[rd][1];

                if(map[ni][nj]==0){
                        ri = ni;
                        rj = nj;
                }
            }else{
            //4단계 청소할 곳이 없는 경우
                int ni = ri - move[rd][0];
                int nj = rj - move[rd][1];
                //벽이 아니면 이동해버리삼;
                if(map[ni][nj]!=1){
                        ri = ni;
                        rj = nj;
                }else break;
            }
        }
        System.out.println(answer);
    }

    static boolean check(){


        for(int d=0;d<4;d++){

            int ni = ri + move[d][0];
            int nj = rj + move[d][1];

            if(map[ni][nj]==0) return true;

        }
        return false; //청소할 곳이 없다... 아맞다 ㅠ


    }


}
