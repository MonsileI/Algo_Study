package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_21317_징검다리건너기_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        //작점 큰점
        int[][]arr = new int[N][2];
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int P = Integer.parseInt(br.readLine());

        int[]dp = new int[N];
        dp[1] = arr[0][0];
        dp[0] = 0;
        for(int i=2;i<N;i++) dp[i] = Math.min(dp[i-1]+arr[i-1][0],dp[i-2]+arr[i-2][1]);

        int min = dp[N-1];

        for(int i=N-1;2<i;i--){
            int sum = dp[i];
            int []tDp = new int[N];
            for(int j=i;j<N;j++){
                tDp[j] = Math.min(tDp[j-1]+arr[j-1][0],tDp[j-2]+arr[j-2][1]);
            }
            min = Math.min(min,tDp[N-1]+P+dp[i]);
            System.out.println(Arrays.toString(tDp));
        }

        System.out.println(min);
    }
}
