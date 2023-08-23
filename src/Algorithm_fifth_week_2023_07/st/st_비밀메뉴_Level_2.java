package Algorithm_fifth_week_2023_07.st;

import java.io.*;
import java.util.*;

public class st_비밀메뉴_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String answer = "normal";
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[M];
        int[]arrN = new int[N];
        int idx = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arrN[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N-1;i++){
           if(arrN[i]!=arr[0]) continue;
           idx = 1;
           boolean flag = true;
           for(int j=i+1;j<N;j++){
               if(arr[idx]==arrN[j]) idx++;
               else {
                   flag = false;
                   break;
               }
               if(idx==M) break;
           }
           if(flag) {
               answer = "secret";
               break;
           }
        }
        System.out.println(answer);
    }
}
