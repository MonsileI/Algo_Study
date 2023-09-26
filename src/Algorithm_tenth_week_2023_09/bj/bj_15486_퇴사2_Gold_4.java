package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_15486_퇴사2_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[][]arr = new int[N+2][2];
        int[]dp = new int[N+2];

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for(int i=1;i<N+2;i++){
            if(max<dp[i]) max = dp[i];
            int next = arr[i][0] + i; //자기 자신 + 걸리는 시간 일수
            if(next<N+2){
                dp[next] = Math.max(dp[next],max+arr[i][1]);
            }
        }
        System.out.println(dp[N+1]);
    }
}
