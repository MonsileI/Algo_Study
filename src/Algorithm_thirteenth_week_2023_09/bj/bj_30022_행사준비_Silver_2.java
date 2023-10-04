package Algorithm_thirteenth_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_30022_행사준비_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][2];
        int[][]tmp1 = new int[N][2];
        int[][]tmp2 = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            tmp1[i][0] = arr[i][0];
            tmp1[i][1] = arr[i][1];
            tmp2[i][0] = arr[i][0];
            tmp2[i][1] = arr[i][1];
        }
        Arrays.sort(tmp1,(o1,o2)->o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
        Arrays.sort(tmp2,(o1,o2)->o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);

        long one = 0;  long two = 0;

        for(int i=0;i<N;i++){
            if(A!=0){
                one += tmp1[i][0];
                A--;
            }else{
                one += tmp1[i][1];
            }
            if(B!=0){
                two += tmp2[i][1];
                B--;
            }else{
                two += tmp2[i][0];
            }
         }


        System.out.println(Math.min(one,two));

    }
}
