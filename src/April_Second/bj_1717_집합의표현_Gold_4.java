package April_Second;

import java.util.*;
import java.io.*;

public class bj_1717_집합의표현_Gold_4 {
    static int N,M,parents[];

    static void Make(){
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
    }

    static void Union(int a,int b){

        int rootA = find(a);
        int rootB = find(b);

        if(rootA!=rootB){
            if(rootA<rootB) parents[rootA] = rootB;
            else parents[rootB] = rootA;
        }
    }

    static int find(int num){
        if(parents[num]==num) return num;
        return find(parents[num]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        Make();
        M = Integer.parseInt(st.nextToken());
        int order = 0, a =0, b=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            order = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(order==0){
                Union(a,b);
            }else{
                if(find(a)!=find(b)) sb.append("NO").append("\n");
                else sb.append("YES").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
