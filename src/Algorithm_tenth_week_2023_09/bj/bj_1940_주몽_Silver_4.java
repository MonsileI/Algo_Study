package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_1940_주몽_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        if(N!=1){
            Arrays.sort(arr);
            int L = 0;int R=N-1;
            while(L<R){
                int sum = arr[L] + arr[R];
                if(sum<=M){
                    if(sum==M) {
                        answer++;
                        R--;
                    }
                    L++;
                }else{
                    R--;
                }
            }
        }
        System.out.println(answer);
    }
}
