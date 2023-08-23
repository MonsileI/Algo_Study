package Algorithm_seventh_week_2023_08.gr;

import java.io.*;
import java.util.*;

public class gr_주유소_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]len = new int[N-1];
        for(int i=0;i<N-1;i++) len[i] = Integer.parseInt(st.nextToken());
        long[]cost = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) cost[i] = Integer.parseInt(st.nextToken());
        long minCost = cost[0];
        long answer= 0;

        for(int i=0;i<N-1;i++){
            if(cost[i]<minCost){
                minCost = cost[i];
            }
            answer += minCost * len[i];
        }
        System.out.println(answer);
    }
}
