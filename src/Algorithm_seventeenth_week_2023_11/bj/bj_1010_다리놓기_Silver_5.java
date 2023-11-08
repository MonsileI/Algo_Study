package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1010_다리놓기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[31][31];
        for(int i=1;i<31;i++)dp[1][i] = i;
        for(int i=2;i<31;i++){
            dp[i][i] = 1;
            for(int j=i+1;j<31;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]+"\n");
        }
        System.out.println(sb.toString());
    }
}
