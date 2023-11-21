package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_4097_수익_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int ans = Integer.MIN_VALUE;
            int sum  =0;
            for(int i=0;i<N;i++){
                int num = Integer.parseInt(br.readLine());
                sum += num;
                ans = Math.max(ans,sum);
                if(sum<0) sum = 0;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
