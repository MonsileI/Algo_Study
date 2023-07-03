package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_9663_NQueen_Gold_4 {
    static int N,answer;
    static int []cols;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        cols = new int[N];
        queen(0);
        System.out.println(answer);
    }
    static boolean check(int row){
        for(int i=0;i<row;i++){
            if(cols[row]==cols[i] ||Math.abs(row-i) == Math.abs(cols[row]-cols[i])) return false;
        }
        return true;
    }
    static void queen(int row){

        if(!check(row-1)) return;

        if(N-1<row) {
            answer++;
            return;
        }

        for(int i=0;i<N;i++){
            cols[row] = i;
            queen(row+1);
        }
    }
}

