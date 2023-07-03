package Jun_Second.bj;

import java.util.*;
import java.io.*;
public class bj_2559_수열_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int []arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        int answer = -987654321;
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<N-K+1;i++){
            System.out.println(i+" : "+(i+K-1));
            answer = Math.max(answer,(sum-arr[i+K-1])-(sum-arr[i]));
        }

        System.out.println(answer);

    }
}

