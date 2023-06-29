package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_2156_포도주시식_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N];
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        if(N<4) System.out.println(Math.max(Math.max(arr[0]+arr[1],arr[1]+arr[2]),arr[0]+arr[2]));
        else{

            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(dp[1],Math.max(arr[0]+arr[2],arr[1]+arr[2]));

            for(int i=4;i<N;i++) dp[i] = Math.max(arr[i-2]+arr[i-3],Math.max(arr[i-1]+dp[i-3],arr[i-1]+arr[i-2]));
            System.out.println(Arrays.toString(dp));
            System.out.println(dp[N-1]);

        }

    }
}
