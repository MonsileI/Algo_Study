package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_17281_야구_Gold_4 {
    static int N;
    static int[][]score;
    static int answer;
    static int []tmp; //순서
    static boolean[]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        score = new int[N][10];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<10;j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tmp = new int[10];
        visited = new boolean[10];

        //최대점수이기 때문에 브루트포스로 탐색
        dfs(1);
        System.out.println(answer);
    }
    static void calc(){

        int sum  = 0; //점수
        int player = 1; //몇번째 플레이어
        int out = 0; //아웃카운트
        boolean[]base = new boolean[3]; //1루 2루 3루
        //이닝
        for(int g=0;g<N;g++){

            while(true){
                int play = score[g][tmp[player]]; //뭐 쳤는지
                switch(play){
                    case 0 : out++;
                        break;
                    case 1 : for(int i=2;-1<i;i--){
                            if(base[i]){
                                if(2<i+1) sum++;
                                else base[i+1] = true;
                                base[i] = false;
                            }
                        }
                            base[0] = true;
                        break;
                    case 2 : for(int i=2;-1<i;i--){
                              if(base[i]) {
                                  if(2<i+2) sum++;
                                  else base[i+2] = true;
                                  base[i] = false;
                              }
                            }
                             base[1] = true;
                        break;
                    case 3 : for(int i=0;i<3;i++) {
                                if(base[i]){
                                    sum++;
                                    base[i] =false;
                                    }
                                }
                            base[2] = true;
                        break;
                    case 4 : for(int i=0;i<3;i++){
                                if(base[i]){
                                    sum++;
                                    base[i] = false;
                                }
                            }
                            sum++;
                        break;
                }

                //다음 플레이어로 바꿔주고, 만약 10이면 1번 플레이어가 다시 플레이
                player++;
                if(player==10) player=1;
                //아웃카운트 체크
                if(3==out){
                    base = new boolean[3];
                    out = 0;
                    break;
                }
            }
        }
        answer = Math.max(answer,sum);

    }
    static void dfs(int depth){

        if(depth==4)depth++;

        if(depth==10){
            tmp[4] = 1;
            calc();
            return;
        }


        for(int i=2;i<10;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
