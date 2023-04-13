package April_Second;

import java.util.*;
import java.io.*;

public class bj_12100_2048Easy_Gold_2 {

    static int N,map[][],answer;
    static boolean[]visited;
    static int [] tmp;

    static int[][]tmpMap;

    static boolean [][] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[5];
        answer = 0;
        tmp = new int[5];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(0);
        System.out.println(answer);
    }
    static void calc(){
        /*
        같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다.
        한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다.
        */

        //맵 복사
        tmpMap = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tmpMap[i][j] = map[i][j];
            }
        }

        //상우하좌
        for(int dd=0;dd<5;dd++){
            //한번 뭉쳐진건지 아닌지 체크할 boolean[];
            check = new boolean[N][N];
            int d = tmp[dd];

            switch(d){
                case 0: up();
                    break;

                case 1: right();
                    break;

                case 2: down();
                    break;

                case 3: left();
                    break;
            }
        }
        int max =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(tmpMap[i][j]!=0 && max < tmpMap[i][j]) max = tmpMap[i][j];
                System.out.println(tmpMap[i][j]);
            }
        }


        answer = Math.max(answer,max);
    }

    static void up(){

        for(int j=0;j<N;j++){
            innerLoop:
            for(int i=1;i<N;i++){
                if(tmpMap[i][j]!=0){
                    int tnum = tmpMap[i][j];
                    int ti = i;
                    while(true){
                        ti--;
                        //마지막값이면 걍 해주기
                        if(ti==0){
                            //0이면 그냥 tnum 저장
                            if(tmpMap[0][j]==0) tmpMap[ti][j] = tnum;
                            //뭐가 있으면
                            else{
                                //조건이 맞으면 2배
                                if(!check[0][j] && tmpMap[ti][j] == tnum){check[0][j]=true; tmpMap[ti][j] *= 2;}
                                //아니면 그 전에 넣어주기
                                else tmpMap[ti+1][j] = tnum;
                            }
                            break innerLoop;
                        }
                        //뭐가 있으면
                        if(tmpMap[ti][j]!=0){
                            //조건이 맞으면 2배
                            if(!check[ti][j] && tmpMap[ti][j] == tnum) {check[ti][j] = true ; tmpMap[ti][j] *= 2;}
                            //아니면 그냥 넣어주기
                            else tmpMap[ti+1][j] = tnum;
                            break innerLoop;
                        }
                    }
                }
            }
        }
        for(int [] i : tmpMap) System.out.println(Arrays.toString(i)+" ;");
    }
    static void right(){

    }
    static void down(){

        for(int j=0;j<N;j++){
            innerLoop:
            for(int i=N-2;i>0;i++){
                if(tmpMap[i][j]!=0){
                    int tnum = tmpMap[i][j];
                    int ti = i;
                    while(true){
                        ti++;
                        //마지막값이면 걍 해주기
                        if(ti==N-1){
                            //0이면 그냥 tnum 저장
                            if(tmpMap[ti][j]==0) tmpMap[ti][j] = tnum;
                                //뭐가 있으면
                            else{
                                //조건이 맞으면 2배
                                if(!check[ti][j] && tmpMap[ti][j] == tnum){check[ti][j]=true; tmpMap[ti][j] *= 2;}
                                //아니면 그 전에 넣어주기
                                else tmpMap[ti-1][j] = tnum;
                            }
                            break innerLoop;
                        }
                        //뭐가 있으면
                        if(tmpMap[ti][j]!=0){
                            //조건이 맞으면 2배
                            if(!check[ti][j] && tmpMap[ti][j] == tnum) {check[ti][j] = true ; tmpMap[ti][j] *= 2;}
                            //아니면 그냥 넣어주기
                            else tmpMap[ti-1][j] = tnum;
                            break innerLoop;
                        }
                    }
                }
            }
        }

    }
    static void left(){

    }
    static void perm(int depth){

        if(depth==5){
            calc();
            return;
        }

        for(int i=0;i<5;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }

    }
}
