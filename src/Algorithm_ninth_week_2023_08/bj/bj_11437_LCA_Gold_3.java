package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_11437_LCA_Gold_3 {
    static int N;
    static List<List<Integer>> list;
    static int depths[], parents[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        StringTokenizer st= null;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        depths = new int[N+1];
        parents = new int[N+1];
        dfs(1,1,0);
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<tc;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)+"\n");
        }
        System.out.println(sb.toString());
    }
    static int LCA(int a,int b){
        int depthA = depths[a];
        int depthB = depths[b];
        while(depthA>depthB){
            a = parents[a];
            depthA--;
        }
        while(depthA<depthB){
            b = parents[b];
            depthB--;
        }
        while(a!=b){
            a = parents[a];
            b = parents[b];
        }
        return a;
    }
    static void dfs(int now, int depth, int parent){
        depths[now] = depth;
        parents[now] = parent;
        for(int next : list.get(now)){
            if(next!=parent){
                dfs(next,depth+1,now);
            }
        }
    }
}
