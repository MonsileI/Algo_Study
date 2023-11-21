package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2624_동전바꿔주기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N+1][2];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> o1[0]-o2[0]);
        int[][]dp = new int[N+1][G+1];
        for(int i=0;i<N+1;i++)dp[i][0] = 1;
        for(int c=1;c<N+1;c++){
            int coin = arr[c][0]; int cnt = arr[c][1];
            for(int j=1;j<G+1;j++){
               for(int i=0;i<cnt+1;i++){
                   if(j-(coin * i)<0) break;
                   dp[c][j] += dp[c-1][j-(coin*i)];
               }
            }
        }
        System.out.println(dp[N][G]);
    }
}
