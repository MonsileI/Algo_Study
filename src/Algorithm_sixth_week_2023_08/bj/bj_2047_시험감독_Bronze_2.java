package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2047_시험감독_Bronze_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[]arr = new double[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int f = Integer.parseInt(st.nextToken()); double s = Integer.parseInt(st.nextToken());
        long answer = 0;
        for(int i=0;i<N;i++){
            if(arr[i]<=f) answer++;
            else{
                double t = arr[i] - f;
                answer += Math.ceil(t/s);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
