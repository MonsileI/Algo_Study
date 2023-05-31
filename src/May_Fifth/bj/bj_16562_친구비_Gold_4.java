package May_Fifth.bj;

import java.util.*;
import java.io.*;
public class bj_16562_친구비_Gold_4 {

    static int N,M,C;
    static int[][]parents;

    //union
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        int min = Math.min(parents[rootA][1],parents[rootB][1]);
        if(rootA!=rootB){
            if(rootB < rootA) {parents[rootA][0] = rootB; parents[rootA][1]=min;}
            else {parents[rootB][0] = rootA;parents[rootB][1]=min;}
        }

    }
    static int find(int num){
        if(parents[num][0]==num) return num;
        return parents[num][0] = find(parents[num][0]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        parents = new int[N+1][2];
        st = new StringTokenizer(br.readLine()," ");
        //make
        for(int i=1;i<N+1;i++){
            parents[i][0] = i;
            parents[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        boolean[]visited = new boolean[N+1];
        int first = find(1);
        sum = parents[first][1];
        visited[first] = true;
        boolean flag = true;
        for(int i=2;i<N+1;i++){
            int num = find(i);
            if(!visited[num]) {sum += parents[num][1];visited[num] = true;}
            if(C<sum) {sb.append("Oh no"); flag = false; break;}
        }
        if(flag) sb.append(sum);
        System.out.println(Arrays.deepToString(parents));
        System.out.println(sb.toString());
    }

}
