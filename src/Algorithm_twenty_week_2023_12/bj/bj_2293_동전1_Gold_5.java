package Algorithm_twenty_week_2023_12.bj;
import java.util.*;
import java.io.*;
public class bj_2293_동전1_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        int[]dp = new int[K+1];
        dp[0]= 1;
        int[]arr= new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int mon = arr[i];
            for(int j=mon;j<K+1;j++){
                dp[j] += dp[j-mon];
            }
        }
        System.out.println(dp[K]);
    }
}
