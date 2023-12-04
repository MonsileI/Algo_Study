    package Algorithm_repeat_week_second_2023_10.bj;

    import java.util.*;
    import java.io.*;

    public class bj_2294_동전2_Gold_5 {
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken()); int G = Integer.parseInt(st.nextToken());
            int[]arr = new int[N+1];
            for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            int[][]dp = new int[N+1][G+1];
            int INF = 987654321;
            for(int i=0;i<N+1;i++){
                for(int j=1;j<G+1;j++){
                    dp[i][j] = INF;
                }
            }
            for(int i=1;i<N+1;i++){
                int coin = arr[i];
                for(int j=0;j<G+1;j++){
                    dp[i][j] = dp[i-1][j];
                    if(coin<=j){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-coin]+1);
                    }
                }
            }
            System.out.println(dp[N][G]==INF ? -1 : dp[N][G]);
        }
    }
