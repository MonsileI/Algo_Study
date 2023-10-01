package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1263_시간관리_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> -(o1[1] - o2[1]));
        int endTime = arr[0][1] - arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][1] < endTime) {
                endTime = arr[i][1];
            }
            endTime = endTime - arr[i][0];
        }

        if(endTime > 0) {
            System.out.println(endTime);
        }else {
            System.out.println(-1);
        }
    }
}
