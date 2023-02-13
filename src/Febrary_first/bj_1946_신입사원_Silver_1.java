package Febrary_first;

import java.util.*;
import java.io.*;
public class bj_1946_신입사원_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){

            int N = Integer.parseInt(br.readLine());
            int[][]arr = new int[N][2];
            int cnt = N;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr,(o1, o2) -> o1[0] - o2[0]);

            int temp = arr[0][1];
            for(int i=1;i<N;i++){
                if( temp  < arr[i][1]) cnt--;
                else temp = arr[i][1];
            }

            sb.append(cnt).append("\n");

        }
        System.out.println(sb.toString());
    }
}
