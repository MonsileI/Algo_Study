package Algorithm_seventh_week_2023_08.pr;

import java.util.*;

public class pr_프렌즈4블록_Level_2 {
    static int N,M;
    static char[][]map;
    static int answer;
    static boolean flag;
    static boolean[][]visited;
    static int[][]move = {{0,1},{1,1},{1,0}};
    public static void main(String[] args) {
        int m = 6;int n=6;
        String[]board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        N = m; M = n;
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = board[i].toCharArray();

        while(true){
            flag = false;
            calc();
            if(!flag) break;
            mapChange();
        }
        System.out.println(answer);
    }
    static void mapChange(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
               if(visited[i][j]){
                  map[i][j] = '#';
               }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='#'){
                    int fi = i;
                    int si = i-1;
                    while(true){
                        if(si<0) break;
                        if(N-1<fi) break;
                        if(map[fi][j]!='#') break;
                        map[fi][j] = map[si][j];
                        map[si][j] = '#';
                        fi++; si++;
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

            }
        }
    }

    static void calc(){
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int cnt = 0;
                if(!visited[i][j]) cnt++;
                if(map[i][j]=='#') continue;
                for(int d=0;d<3;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) break;
                    if(map[ni][nj]!=map[i][j]) break;
                    if(!visited[ni][nj]) cnt++;
                    if(d==2) {
                        answer += cnt;
                        flag = true;
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                    }
                }
            }
        }
    }

}

