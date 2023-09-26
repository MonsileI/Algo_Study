package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_15654_N과M5_Silver_3 {
    static int N,M,arr[];
    static StringBuilder sb ;
    static int[]tmp;
    static boolean[]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        tmp = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        sb = new StringBuilder();
        perm(0);
        System.out.println(sb.toString());
    }
    static void perm(int depth){

        if(depth==M){
            for(int i=0;i<M;i++) sb.append(tmp[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]= true;
                tmp[depth] = arr[i];
                perm(depth+1);
                visited[i] = false;
            }
        }

    }
}

