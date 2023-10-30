package Algorithm_sixeenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_30390_우주왕자사교파티_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long min = Math.min(A,B);
        long max = Math.max(A,B);
        long answer = 0;
        if(min<=K) answer = max+K;
        else{
            while(true||-1<K){
                if((max-K)%(min+K)==0){
                    answer = min+K;
                    break;
                }
                K--;
            }
        }
        System.out.println(answer);
    }
}
