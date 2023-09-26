package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_30036_INK_Silver_1 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int I = Integer.parseInt(st.nextToken()); //물감개수
        N = Integer.parseInt(st.nextToken()); //N크기
        int K = Integer.parseInt(st.nextToken()); //명령개수
        char[]inks = new char[I];
        int[]id = {-1,0,1,0,-1,1,1,-1};
        int[]jd = {0,1,0,-1,1,1,-1,-1};
        String colors = br.readLine();
        for(int y=0;y<I;y++) inks[y] = colors.charAt(y);
        char[][]map = new char[N][N];
        int i = 0; int j = 0;
        for(int y=0;y<N;y++){
            String str = br.readLine();
            for(int x=0;x<N;x++){
                map[y][x] = str.charAt(x);
                if(map[y][x]=='@') {
                    i = y; j = x;
                    map[y][x] = '.';
                }
            }
        }
        char[]order = new char[K];
        String orStr = br.readLine();
        for(int y=0;y<K;y++)order[y] = orStr.charAt(y);
        int idx =0;
        int ink = 0;
        int ni= 0; int nj = 0;
        int inkCnt = 0;
        while(idx<K){
            char orCh = order[idx];
            switch(orCh){
                case 'U': ni = i+id[0]; nj= j+jd[0];
                          if(!range(ni,nj)) break;
                          i = ni; j = nj;
                    break;
                case 'R': ni = i+id[1]; nj= j+jd[1];
                    if(!range(ni,nj)) break;
                    i = ni; j = nj;
                    break;
                case 'D':  ni = i+id[2]; nj= j+jd[2];
                    if(!range(ni,nj)) break;
                    i = ni; j = nj;
                    break;
                case 'L':  ni = i+id[3]; nj= j+jd[3];
                    if(!range(ni,nj)) break;
                    i = ni; j = nj;
                    break;

                case 'j': ink++;
                    break;
                case 'J': char color = inks[inkCnt % I];
                          for(int d=0;d<8;d++){
                              for(int t=0;t<=ink;t++){
                                  ni = i + (id[d] * t); nj = j + (jd[d] * t);
                                  if(!range(ni,nj)) continue;
                                  if(map[ni][nj]!='.') map[ni][nj] = color;
                              }
                          }
                          ink = 0;
                          inkCnt++;
                    break;
            }
            idx++;
        }
        StringBuilder sb= new StringBuilder();
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(y==i&&x==j) sb.append("@");
                else sb.append(map[y][x]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
    static boolean range(int i,int j){
        if(i<0||j<0||N-1<i||N-1<j) return false;
        return true;
    }
}
