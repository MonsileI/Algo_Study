package May_Fifth.bj;

import java.io.*;
import java.util.*;

public class bj_1976_여행가자_Gold_4 {
    static int N,M,parents[];

    static void make(){
        for(int i=1;i<N+1;i++) parents[i] = i;
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB){
            if(rootB < rootA) parents[rootA] = rootB;
            else parents[rootB] = rootA;
        }
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        parents = new int[N+1];
        make();
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                int num = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                if(num==1) union(i,j);
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        boolean flag = true;
        int[]arr = new int[M];
        int first = Integer.parseInt(st.nextToken());
        first = find(first);
        for(int i=1;i<M;i++){
            int b = arr[i];
            if(find(first)!=find(b)) {flag = false; break;};
        }
        String answer = flag ? "YES" : "NO";
        System.out.println(answer);
    }
}
