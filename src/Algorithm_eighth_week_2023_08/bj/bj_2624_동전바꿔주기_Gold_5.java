package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2624_동전바꿔주기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        int len = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            len += arr[i][1];
        }
        int[]coin = new int[len+1];
        int idx = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<arr[i][1];j++){
                coin[idx++] = arr[i][0];

            }
        }

        System.out.println(Arrays.toString(coin));
        int[][]dp = new int[len+1][money+1];

    }
}
