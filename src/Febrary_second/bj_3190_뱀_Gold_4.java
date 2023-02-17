package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_3190_뱀_Gold_4 {
    static int N,K,si,sj,sd;
    static int [][] map;
    static int [][]dirs = {{-1,0},{0,1},{1,0},{0,-1}};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        si = 0;
        sj = 0;
        sd = 1;
        StringTokenizer st = null;
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int ai = Integer.parseInt(st.nextToken());
            int aj = Integer.parseInt(st.nextToken());
            map[ai][aj] = 3; //사과
        }

        map[0][0] = 1; //1 뱀

        int tc = Integer.parseInt(br.readLine());
        int idx = 0;
        int time = 0;

        outLoop:
        while(idx<tc){

            st = new StringTokenizer(br.readLine());
            int turnTime = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            while(time<turnTime){
                int ni = si + dirs[sd][0];
                int nj = sj + dirs[sd][0];

                if(ni<0||nj<0||N-1<ni||N-1<nj) break outLoop;

                

            }
















        }







    }
}
