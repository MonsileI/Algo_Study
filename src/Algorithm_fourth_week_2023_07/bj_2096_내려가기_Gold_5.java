package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2096_내려가기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]maxDp = new int[N+1][3];
        int[][]minDp = new int[N+1][3];
        maxDp[0][0] = maxDp[0][1] = maxDp[0][2] = minDp[0][0] = minDp[0][1] = minDp[0][2] =0;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            maxDp[i][0] = f + Math.max(maxDp[i-1][0],maxDp[i-1][1]);
            maxDp[i][1] = s + Math.max(Math.max(maxDp[i-1][0],maxDp[i-1][1]),maxDp[i-1][2]);
            maxDp[i][2] = t + Math.max(maxDp[i-1][1],maxDp[i-1][2]);

            minDp[i][0] = f + Math.min(minDp[i-1][0],minDp[i-1][1]);
            minDp[i][1] = s + Math.min(Math.min(minDp[i-1][0],minDp[i-1][1]),minDp[i-1][2]);
            minDp[i][2] = t + Math.min(minDp[i-1][1],minDp[i-1][2]);

        }
        int max = Math.max(Math.max(maxDp[N][0],maxDp[N][1]),maxDp[N][2]);
        int min = Math.min(Math.min(minDp[N][0],minDp[N][1]),minDp[N][2]);
        System.out.println(max+" "+min);

    }
}
