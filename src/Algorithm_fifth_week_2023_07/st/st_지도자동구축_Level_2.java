package Algorithm_fifth_week_2023_07.st;

import java.util.*;
import java.io.*;
public class st_지도자동구축_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[16];
        arr[0] = 4;
        int num = 3;
        int idx = 1;
        for(int i=1;i<16;i++){
            arr[i] = num * num;
            idx *= 2;
            num += idx;
        }
        System.out.println(arr[N]);
    }
}
