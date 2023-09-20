package Algorithm_twelveth_week_2023_09.bj;
import java.util.*;
import java.io.*;
public class bj_1535_안녕_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]w = new int[N+1]; int [] h = new int[N+1];
        int[][]dp = new int[N+1][100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++) w[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) h[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i=1;i<N+1;i++){
            int cost = w[i];
            for(int j=1;j<100;j++){
                dp[i][j] = dp[i-1][j];
                if(cost<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-cost]+h[i]);
                }
                answer = Math.max(answer,dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}
