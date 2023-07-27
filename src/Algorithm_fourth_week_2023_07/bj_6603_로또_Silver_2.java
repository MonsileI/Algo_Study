package Algorithm_fourth_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_6603_로또_Silver_2 {
    static int arr[],tmp[];
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            arr = new int[N]; tmp = new int[6];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            comb(0,0);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void comb(int depth, int start){

        if (depth == 6) {
            for(int i=0;i<6;i++){
                sb.append(arr[tmp[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }
}
