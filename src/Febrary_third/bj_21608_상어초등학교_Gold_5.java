package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_21608_상어초등학교_Gold_5 {

    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N, map[][];
    static int[][]info;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[(N*N)+1][5];
        StringTokenizer st = null;
        for(int i=1;i<(N*N)+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
            info[i][3] = Integer.parseInt(st.nextToken());
            info[i][4] = Integer.parseInt(st.nextToken());
        }


        map = new int[N][N];

        for(int c=1;c<(N*N)+1;c++) calc(c);


        int answer = 0 ;

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
                int cnt = 0;
                int num = 0;
                for(int d=1;d<(N*N)+1;d++){
                    if(map[i][j]==info[d][0]) {
                        num = d;
                        break;
                    }
                }
                for(int d=0;d<4;d++){

                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;


                    InnerLoop:
                    for(int t=1;t<5;t++) {
                        if(info[num][t]==map[ni][nj]){
                            cnt++;
                            break InnerLoop;
                        }
                    }
                }


                if(cnt>=1) answer += Math.pow(10,cnt-1);

            }
        }

        System.out.println(answer);

    }

    static void calc(int num){

        int bestBlank= -1;
        int bestLike = -1;
        int bestUp = -1;
        int bestLeft = -1;

        int[]place= new int[2];

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                if(map[i][j]!=0) continue;

                int b= 0;
                int li =0;

                for(int d=0;d<4;d++){

                    int ni = i + move[d][0];
                    int nj = j + move[d][1];

                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;

                    int []tmp = info[num];
                    //좋아하는지 확인
                    innerLoop:
                    for(int k=1;k<5;k++){
                        if(tmp[k]==map[ni][nj]) {
                            li++;
                            break innerLoop;
                        }
                    }
                    //blank인지 확인
                    if(map[ni][nj]==0) b++;
                }


                if(bestLike<li){ place[0] =i ; place[1] = j; bestLike = li; bestBlank = b; bestUp = i; bestLeft = j; }
                else if(bestLike==li){
                    if(bestBlank < b) { place[0] =i ; place[1] = j; bestLike = li; bestBlank = b; bestUp = i; bestLeft = j; }
                    else if(bestBlank == b){
                        if(bestUp > i) { place[0] =i ; place[1] = j; bestLike = li; bestBlank = b; bestUp = i; bestLeft = j;}
                        else if(bestUp==i){
                            if(bestLeft > j) {place[0] =i ; place[1] = j; bestLike = li; bestBlank = b; bestUp = i; bestLeft = j;}
                            }
                        }
                }
            }
        }

        map[place[0]][place[1]] = info[num][0];

    }
}
