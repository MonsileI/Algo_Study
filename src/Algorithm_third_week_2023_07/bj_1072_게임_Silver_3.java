package Algorithm_third_week_2023_07;

import java.io.*;
import java.util.*;
public class bj_1072_게임_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        // X 게임 횟수, Y 이긴 게임 Z는 변하는 승률
        int L  =0 ; int R = 2000000000;
        double origin = Y*100/X;
        origin = (int)origin;
        if(origin>=99) L = -1;
        else{
            while(L<R){
                int mid = (L+R)/2;
                double sum = (Y+mid) * 100 /(X+mid);
                if(origin<sum){
                    R = mid;
                }else{
                    L = mid+1;
                }
            }
        }
        System.out.println(L);
    }
}
