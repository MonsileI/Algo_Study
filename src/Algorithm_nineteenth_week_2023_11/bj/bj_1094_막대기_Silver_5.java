package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1094_막대기_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        String binary = Integer.toBinaryString(G);
        int N = binary.length();
        int ans = 0;
        for(int i=0;i<N;i++) if(binary.charAt(i)=='1') ans++;
        System.out.println(ans);

    }
}
