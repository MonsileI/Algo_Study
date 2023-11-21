package Algorithm_eighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_11052_카드구매하기_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int [][]dp = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            int money = arr[i];
            for(int j=0;j<N+1;j++){
                dp[i][j] = dp[i-1][j];
                if(i<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-i]+money);
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}
