package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;

public class bj_15655_N과M6_Silver_3 {
    static StringBuilder sb = new StringBuilder();
    static int[]tmp;
    static int N,M;
    static int []arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tmp = new int[M];
        arr = new int[N];
        st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb.toString());
    }
    static void dfs(int depth,int start){
        if(depth==M){
            for(int i=0;i<M;i++)sb.append(tmp[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
                tmp[depth] = arr[i];
                dfs(depth+1,i+1);
            }
        }
}
