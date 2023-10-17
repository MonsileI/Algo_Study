package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2096_내려가기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]maxDp = new int[N][3];
        int[][]minDp = new int[N][3];
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        maxDp[0][0] = minDp[0][0] = Integer.parseInt(st.nextToken());
        maxDp[0][1] = minDp[0][1] = Integer.parseInt(st.nextToken());
        maxDp[0][2] = minDp[0][2] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            minDp[i][0] = Math.min(minDp[i-1][0],minDp[i-1][1]) + a;
            minDp[i][1] = Math.min(minDp[i-1][0],Math.min(minDp[i-1][1],minDp[i-1][2])) + b;
            minDp[i][2] = Math.min(minDp[i-1][1],minDp[i-1][2]) + c;

            maxDp[i][0] = Math.max(maxDp[i-1][0],maxDp[i-1][1]) + a;
            maxDp[i][1] = Math.max(maxDp[i-1][0],Math.max(maxDp[i-1][1],maxDp[i-1][2])) + b;
            maxDp[i][2] = Math.max(maxDp[i-1][1],maxDp[i-1][2]) + c;
        }
        System.out.println(Math.max(maxDp[N-1][0],Math.max(maxDp[N-1][1],maxDp[N-1][2]))+" "+Math.min(minDp[N-1][0],Math.min(minDp[N-1][1],minDp[N-1][2])));
    }
}
