package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_1389_케빈베이컨의6단계법칙_Silver_1 {


    static int N,M;

    static int [][] map;

    static int ansCnt = 987654321;
    static int ansNum = 987654321;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to]= map[to][from] = 1;
        }





    }
}
