package January_Fifth;
import java.util.*;
import java.io.*;


public class bj_1978_소수찾기_SIlver_5 {
    static int answer=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num==2) {
                answer++;
                continue;
            }else if(num==1) continue;
             else if(num%2==0) continue;
            calc(num);
        }

        System.out.println(answer);

    }
    static void calc(int num){

        for(int i=2;i<=Math.sqrt(num);i++) if(num%i==0) return;
        answer++;

    }
}
