package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_2473_세용액_Gold_3 {
    static long[]pick = new long[3];
    static long max = 3000000000L;
    static int N;
    static long[]arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new long[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i=0;i<N-2;i++) calc(i);
        Arrays.sort(pick);
        for(int i=0;i<3;i++) System.out.print(pick[i]+" ");

    }
    static void calc(int idx){

        int L = idx+1;
        int R = N-1;

        while(L<R){

            long sum = arr[idx] + arr[L] + arr[R];
            long sumAbs = Math.abs(sum);
            if(sumAbs<max){
                max = sumAbs;
                pick[0] = arr[idx];
                pick[1] = arr[L];
                pick[2] = arr[R];
            }


            if(sum<0) L++;
            else R--;

        }


    }
}
