package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_2193_이친수_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[]arr = new long[N+1];
        long answer = 0;
        if(N<3) answer = 1;
        else{
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 1;
            for(int i=3;i<N+1;i++){
                arr[i] = arr[i-1]+arr[i-2];
            }
            answer = arr[N];
        }
        System.out.println(answer);
    }
}
