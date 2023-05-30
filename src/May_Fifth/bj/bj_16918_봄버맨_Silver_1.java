package May_Fifth.bj;

import java.io.*;
import java.util.*;

public class bj_16918_봄버맨_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        char[][]firMap = new char[N][M];
        int[][]map = new int[N][M];
        int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<N;i++) {
            String str =  br.readLine();
            for(int j=0;j<M;j++){
                firMap[i][j] = str.charAt(j);
                if(firMap[i][j]=='O') map[i][j]=3;
            }
        }
        int check = 0;
        while(s<0){

            if(check==0){
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(map[i][j]==1) {
                            map[i][j] = 0;
                            for(int d=0;d<4;d++) {
                                int ni = i + dir[d][0]; int nj = j + dir[d][1];
                                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                                map[ni][nj] = 0;
                            }
                        }else if(map[i][j]!=0){map[i][j] -= 1;}
                    }
                }
                check++;
                s--;
                continue;
            }else if(check==1){
                for(int i=0;i<N;i++) {
                    for(int j=0;j<M;j++) {
                        if(map[i][j]==0){map[i][j]=3;}
                        else {map[i][j] -=1;}
                    }
                }
                continue;
            }else{
                check=0;
                continue;
            }







        }

    }
}
