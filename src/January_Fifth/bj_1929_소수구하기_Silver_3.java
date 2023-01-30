package January_Fifth;

import java.util.*;
import java.io.*;
public class bj_1929_소수구하기_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        for(int i=N;i<=M;i++){
            if(i==2) sb.append(i).append("\n");
            else if(i%2==0) continue;
            else if(i==1) continue;
            else {
                if(soo(i)) sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());

    }
    static boolean soo(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
