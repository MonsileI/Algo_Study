package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_2167_2차원배열의합_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][M];
        int[][]sumMap = new int[N+1][M+1];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<N+1;i++){
            int sum = 0;
            for(int j=1;j<M+1;j++){
                sum += map[i-1][j-1];
                sumMap[i][j] = sum;
            }
        }
        for(int j=1;j<M+1;j++){
            int sum =0;
            for(int i=1;i<N+1;i++){
                sum += sumMap[i][j];
                sumMap[i][j] = sum;
            }
        }
        int order = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int o=0;o<order;o++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken())-1;
            int fj = Integer.parseInt(st.nextToken())-1;
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            int num = sumMap[fi][fj] - sumMap[fi][sj] - sumMap[si][fj] + sumMap[si][sj];
            sb.append(num+"\n");
        }
        System.out.println(sb.toString());
    }
}
