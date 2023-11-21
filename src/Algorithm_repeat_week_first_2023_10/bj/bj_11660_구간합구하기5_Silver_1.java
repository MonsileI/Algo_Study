package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_11660_구간합구하기5_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][N+1];
        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][]sumMap = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            int sum = 0;
            for(int j=1;j<N+1;j++){
                sum += map[i][j];
                sumMap[i][j] = sum;
            }
        }
        for(int j=1;j<N+1;j++){
            int sum = 0;
            for(int i=1;i<N+1;i++){
                sum += sumMap[i][j];
                sumMap[i][j] = sum;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t=0;t<M;t++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken())-1;
            int fj = Integer.parseInt(st.nextToken())-1;
            int si = Integer.parseInt(st.nextToken())-1;
            int sj = Integer.parseInt(st.nextToken())-1;
            int sum = sumMap[fi][fj]+sumMap[si+1][sj+1] - (sumMap[fi][sj+1] + sumMap[si+1][fj]);
            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());
    }
}
