package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_11724_연결요소의개수_Silver_2 {
    static int N;
    static int[]parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a)!=find(b)) union(a,b);
        }
        int ans = 0;
        boolean[]v = new boolean[N+1];
        for(int i=1;i<N+1;i++){
            if(!v[find(parents[i])]){
                v[find(parents[i])] = true;
                ans++;
            }
        }

        System.out.println(ans);
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }

}
