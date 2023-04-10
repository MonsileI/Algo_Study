package April_Second;

import java.util.*;
import java.io.*;
public class bj_14499_주사위굴리기_Gold_4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken()); int si = Integer.parseInt(st.nextToken()); int sj= Integer.parseInt(st.nextToken());int K  = Integer.parseInt(st.nextToken());
        int [][]map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}
