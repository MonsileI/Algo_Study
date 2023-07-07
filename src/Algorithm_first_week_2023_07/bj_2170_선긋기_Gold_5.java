package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2170_선긋기_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        int answer = 0;
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i=1;i<N;i++){
            if(end<arr[i][0]){
                answer += end - start;
                start = arr[i][0];
                end = arr[i][1];
            }else{
                end = Math.max(end,arr[i][1]);
            }
        }
        answer += end - start;
        System.out.println(answer);

    }
}
