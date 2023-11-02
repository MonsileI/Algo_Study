package Algorithm_sixeenth_week_2023_10.복습;
import java.util.*;
import java.io.*;
public class bj_2470_두용액_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int L = 0;
        int R = N-1;
        long answer = 987654321;
        int f = 0; int s = 0;
        while(L<R){
            long num = Math.abs(arr[L] + arr[R]);
            if(num<answer){
                answer =num;
                f = arr[L];
                s = arr[R];
            }
            if(num>0) R--;
            else L++;

        }
        System.out.println(f+" "+s);
    }
}
