package May_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_1789_수들의합_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long N = 0;
        long answer = 0;
        for(int i=1;i<=S;i++){
            if(N==S) break;
            S -= i;
            answer++;
        }
        System.out.println(answer);

        //1 1
        //2 1
        //3 1 2 2
        //4 1 3 2
        //5 2 3 2
        //6 1 2 3 3
        //7 1 2 4 3
        //8 1 3 4 3
        //9 2 3 4 3
        //10 1 2 3 4 4
        //11 1 2 3 5 4
        //12 1 2 3 8 4
        //13 1 2 3 9 4
        //14 1 2 3 10 4
        //15 1 2 3 4 5 5

        //22  333  4444  55555 666666
       // 12 | 345  | 6789  | 10 11 12 13 14 | 15 16 17 18 19







    }
}
