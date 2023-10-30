package Algorithm_sixeenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_2302_극장좌석_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N + 1];
        for(int i=0;i<M;i++) check[Integer.parseInt(br.readLine())] = true;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<N+1;i++){
            if(!check[i]) cnt++;
            else if(check[i] && cnt!=0) {
                list.add(cnt);
                cnt = 0;
            }
        }
        if(cnt!=0) list.add(cnt);
        int[]dp = new int[41];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<41;i++)dp[i] = dp[i-1] + dp[i-2];
        int answer = 1;
        for(int i : list) answer *= dp[i];
        System.out.println(answer);
    }
}
