package May_Fifth.bj;

import java.io.*;
import java.util.*;

public class bj_UnionFind {
    static int N,M,parents[];

    static void make(){
        for(int i=1;i<N+1;i++) parents[i] = i;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB){
            if(rootA<rootB) parents[rootA] = rootB;
            else parents[rootB] = rootA;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M= Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        make();
        StringBuilder sb= new StringBuilder();
        int act= 0;int fir=0;int sec=0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            act = Integer.parseInt(st.nextToken());  fir = Integer.parseInt(st.nextToken());  sec = Integer.parseInt(st.nextToken());
            //합친다
            if(act==0) union(fir,sec);
            //비교한다.
            else{
                if(find(fir) != find(sec)) sb.append("NO").append("\n");
                else sb.append("YES").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
