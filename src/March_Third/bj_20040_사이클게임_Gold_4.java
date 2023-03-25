package March_Third;

import java.util.*;
import java.io.*;
public class bj_20040_사이클게임_Gold_4 {
    static int N, parents[];
    static void make(){
        for(int i=1;i<N+1;i++)parents[i] = i;
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
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        make();

        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a)!=find(b)){
                union(a,b);
            }else{
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}

