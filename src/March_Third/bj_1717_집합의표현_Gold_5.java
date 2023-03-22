package March_Third;

import java.util.*;
import java.io.*;
public class bj_1717_집합의표현_Gold_5 {

    static int N,M,parents[];

    static void make(){
        for(int i=1;i<N+1;i++) parents[i] = i;
    }

    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }

    static void union(int a,int b){

        int rootA = find(a);
        int rootB = find(b);

        if(rootA!=rootB){
            if(rootA<rootB) parents[rootA] = rootB;
            else parents[rootB] = rootA;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        make();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            //0 유니온 1 파인드
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(num==0) union(a,b);
            else{
                if(find(a) ==find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
             }
        }

        System.out.println(sb.toString());
    }
}
