package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_12852_1로만들기2_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if(N==1) sb.append(1);
        else if(N==2) sb.append(2+" "+1);
        else{
            sb.append(N+" ");
            while(true){

                if(N%3==0) N /= 3;
                else if(N%2==0) N /= 2;
                else N--;
                sb.append(N+" ");
                if(N==1) break;
            }
        }
        System.out.println(sb.toString());
    }
}
