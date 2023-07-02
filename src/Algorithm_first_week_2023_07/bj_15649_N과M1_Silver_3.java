package Algorithm_first_week_2023_07;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class bj_15649_N과M1_Silver_3 {
    static int N,len;
    static int[]tmp;
    static boolean[]visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        tmp = new int[N];
        visited = new boolean[N];
        sb = new StringBuilder();
        comb(0);
        System.out.println(sb.toString());
    }

    static void comb(int depth){

        if(depth==len){
            for(int i=0;i<len;i++) sb.append((tmp[i]+1)+" ");
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                comb(depth+1);
                visited[i] = false;
            }
        }
    }

}
