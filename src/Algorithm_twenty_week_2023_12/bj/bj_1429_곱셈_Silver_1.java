package Algorithm_twenty_week_2023_12.bj;
import java.util.*;
import java.io.*;
public class bj_1429_곱셈_Silver_1 {
    static long C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.println(cal(a,b));
    }
    static long cal(long a,long b){

        if(b==1) return a&C;

        long tmp = cal(a,b/2);

        if(b%2==1) return (tmp * tmp % C ) * a % C;
        return tmp * tmp % C;


    }
}
