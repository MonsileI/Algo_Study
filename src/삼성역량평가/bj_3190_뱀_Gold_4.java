package 삼성역량평가;

import java.util.*;
import java.io.*;
public class bj_3190_뱀_Gold_4 {

    static class Snake{
        int dir; int range;

        public Snake(int dir, int range) {
            this.dir = dir;
            this.range = range;
        }


    }

    public static void main(String[] args) throws Exception {
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int apple = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[][]map = new int[N][N];

        for(int a=0;a<apple;a++){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            map[i][j] = 2; //사과
        }
        int order = Integer.parseInt(br.readLine());
        Snake[] sArr = new Snake[order];
        int total = 0; //총 뱀이 이동할 거리
        for(int i=0;i<order;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            r -= total;

            char dir =st.nextToken().charAt(0);
            int d = 0;
            total += r;
            if(dir=='D') d = 1; //오른쪽
            else d = -1; //왼쪽

            Snake snake = new Snake(d,r);
            sArr[i] = snake;
        }


        int si = 0; int sj =0; int ti=0; int tj=0; int tRange=0; int head = 1; //처음 머리 위치, 꼬리 위치, 머리 방향(우측)
        int[] info = new int[10000]; //뱀이 이동시 어느 방향으로 움직였는지 알려주는 배열
        info[0] = 1; //처음엔 오른쪽으로 이동
        map[0][0] = 1; //처음 위치 1
        int answer = 0 ; //얼마나 이동했는지 초
        //이동해봅시다.

        int o = 0;

        OuterLoop:
        while (true) {
            int range = 0;
            int dir = 0;
            //다 돌아도 갈 곳이 있으면 이렇게 해주자.
            if(o==order) {
                 range =10000;
                 dir = head;
            }else {

                 Snake snake = sArr[o++]; //뱀이 할 짓
                 range = snake.range; //이동거리
                 dir = snake.dir; //돌릴 위치
            }
            for(int r=0;r<range;r++){

                //이동할 다음 위치
                int ni = si + move[head][0];
                int nj = sj + move[head][1];

                //범위를 넘어가면 게임 오버
                if(ni<0||nj<0||N-1<ni||N-1<nj) break OuterLoop;
                
                //초 업데이트
                answer++;
                
                //아무것도 없을 시에 머리이동 + 꼬리이동
                if(map[ni][nj]==0){
                     //이동 거리 업데이트
                    map[ni][nj]=1;
                    info[answer] = head; //이 초에는 이 방향으로 움직였음!

                    si = ni; sj = nj ; //머리 위치 업데이트
                    int tail = info[++tRange]; //꼬리 위치를 알아보고 꼬리 위치도 이동시키기 위해 ++
                    //꼬리 자리 0으로 다시 비워줌

                    map[ti][tj] = 0;
                    //꼬리 위치 업데이트
                    ti += move[tail][0];
                    tj += move[tail][1];
                    //사과 자리이면 머리만 이동
                }else if(map[ni][nj]==2){
                     //이동 거리 업데이트
                    map[ni][nj]=1;
                    info[answer] = head; //이 초에는 이 방향으로 움직였음!
                    si = ni; sj = nj; //머리 위치 업데이트
                //만약 자기 몸(1)을 만났으면 break;
                }else { answer--;break OuterLoop; }


            }

            //머리 이동
            if(dir==1) head = (head+1) %4;
            else head = (head+3) %4;



        }

        System.out.println(++answer);

    }
}
