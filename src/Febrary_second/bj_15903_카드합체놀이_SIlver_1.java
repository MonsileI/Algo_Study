package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_15903_카드합체놀이_SIlver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Turn = Integer.parseInt(st.nextToken());

        long [] arr = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        while(0<Turn){

            long num = arr[0] + arr[1];
            arr[0] = num;
            arr[1] = num;
            Arrays.sort(arr);
            Turn--;
        }

        long ans = 0;
        for(int i=0;i<N;i++) ans += arr[i];

        System.out.println(ans);



    }
}
