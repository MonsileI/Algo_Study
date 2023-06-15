package Jun_Second.bj;

import java.util.*;
import java.io.*;
public class bj_1717_집합의표현_Gold_5 {

    static int N,M,parent[];
    static void make(){
        parent = new int[N+1];
        for(int i=0;i<N+1;i++) parent[i] =i;
    }

    static int find(int num){
        if(num==parent[num]) return num;
        return find(parent[num]);
    }
    static void union(int a, int b){

        int rootA = find(a);
        int rootB = find(b);

        if(rootA!=rootB){
            if(rootA<rootB) parent[rootA] = rootB;
            else parent[rootB] = rootA;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
         N = Integer.parseInt(st.nextToken());  M = Integer.parseInt(st.nextToken());
        make();
        int act = 0; int from = 0; int to =0;
        StringBuilder sb = new StringBuilder();
         for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            act = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            if(act==0){
                union(from,to);
            }else{
                if(find(from)!=find(to)) sb.append("NO").append("\n");
                else sb.append("YES").append("\n");
            }

        }

        System.out.println(sb.toString());
    }

}
