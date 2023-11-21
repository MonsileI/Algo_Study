package Algorithm_fifteenth_week_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_과일구매_Level_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int value2 = (int) (value/num);
            arr[i][0] = value2;
            arr[i][1] = num;
        }
        Arrays.sort(arr,(o1,o2)->-(o1[0]-o2[0]));
        long ans = 0;
        OuterLoop:
        for(int i=0;i<N;i++) {
            int value = arr[i][0];
            int num = arr[i][1];
            for(int j=0;j<num;j++) {
                if(M==0) break OuterLoop;
                ans+=value;
                M--;
            }
        }
        System.out.println(ans);
    }
}
