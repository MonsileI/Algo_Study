package Algorithm_eleventh_week_2023_09.swea;

import java.util.*;
import java.io.*;
public class Solution_1859_백만장자프로젝트_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            long answer = 0;
            int max = 0;
            for(int i=N-1;-1<i;i--){
                if(max<arr[i]){
                    max = arr[i];
                }else{
                    answer += (max-arr[i]);
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
