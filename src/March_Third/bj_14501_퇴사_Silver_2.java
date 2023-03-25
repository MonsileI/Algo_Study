package March_Third;

import java.util.*;
import java.io.*;
public class bj_14501_퇴사_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+15];
        int[]day = new int[N+15];
        int[]money = new int[N+15];

        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            day[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i=0;i<N+1;i++){

            dp[i] = Math.max(dp[i],max);
            //day에 걸릴 수 + 지금 일수
            dp[day[i]+i] = Math.max(dp[day[i]+i], dp[i]+money[i]);
            max = Math.max(dp[i],max);

        }

        System.out.println(max);

    }
}
