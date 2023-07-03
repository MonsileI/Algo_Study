package Jun_third.bj;

import java.util.*;
import java.io.*;
public class bj_11660_구간합구하기5_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][N+1]; int sum = 0;

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
               map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1]+ Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken());
            int fj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            sb.append(map[si][sj] - map[fi-1][sj] - map[si][fj-1] + map[fi-1][fj-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
