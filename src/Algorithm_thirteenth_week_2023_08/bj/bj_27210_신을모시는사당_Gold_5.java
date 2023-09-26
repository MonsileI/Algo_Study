package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_27210_신을모시는사당_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = 0;
        int two = 0;
        int max = 0;
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num==1){
                one += 1;
                two -= 1;
            }else{
                one -= 1;
                two += 1;
            }
            if(one<0) one = 0;
            if(two<0) two = 0;
            max = Math.max(max,Math.max(one,two));
        }
        System.out.println(max);




    }
}
