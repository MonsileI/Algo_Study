package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_16194_카드구매하기2_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N+1];
        for(int i=1;i<N+1;i++){
            dp[i] = arr[i];
            for(int j=1;j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j]+arr[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
