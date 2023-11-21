package Algorithm_seventeenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_1806_부분합_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int []arr=  new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int L =0; int R = 0;
        int sum  = 0;
        int ans = 987654321;
        while(true){
            if(sum>=M) {
                ans = Math.min(ans, R-L);
                sum -= arr[L++];
            }else{
                if(R==N) break;
                sum += arr[R++];
            }
        }
        System.out.println(ans==987654321 ? 0 : ans);
    }
}
