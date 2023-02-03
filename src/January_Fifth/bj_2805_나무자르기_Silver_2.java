package January_Fifth;

import java.util.*;
import java.io.*;
public class bj_2805_나무자르기_Silver_2 {
    static int N,M;
    static int []arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        long start = 0; long end = arr[N-1];
        while(start<=end){

            long mid = (start+end) / 2;
            long total = 0;

            for(int i=0;i<N;i++) if(mid < arr[i]) total += arr[i]- mid;

            //total = 자른 가지 크기
            //mid = 높이
            // 자른 가지 크기가 M보다는 크면서, 높이는 가장 낮은 친구가 필요함

            //일단 목표는 완수 해야되니까 M보다는 커야됨
            if (M <= total ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        System.out.println(end);
    }
}
