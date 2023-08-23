package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_20955_민서의응급수술_Gold_4 {

    static int N;
    static int[]parents;

    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB){
            parents[rootA] = rootB;
        }else{
            parents[rootB] = rootA;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
          st = new StringTokenizer(br.readLine()," ");
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          if(find(a)!=find(b)){
              union(a,b);
          }
        }
        boolean[]check = new boolean[N+1];
        int ans = 0;
        for(int i=1;i<N+1;i++){
            if(!check[parents[i]]){
                check[parents[i]] = true;
                ans++;
            }
        }
        ans--;
        System.out.println(ans);
    }
}
