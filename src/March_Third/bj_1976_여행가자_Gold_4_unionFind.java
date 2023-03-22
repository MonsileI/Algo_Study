package March_Third;

import java.util.*;
import java.io.*;
public class bj_1976_여행가자_Gold_4_unionFind {

    static int N,M,parents[];
    static String answer = "YES";

    static void make(){
        for(int i=1;i<N+1;i++) parents[i] = i;
    }

    static int find(int num){
        if(parents[num] == num) return num;
        return parents[num] =find(parents[num]);
    }

    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA!=rootB){
            if(rootA<rootB) parents[rootA]= rootB;
            else parents[rootB] = rootA;
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        make();
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i=1;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(start != find(num)){
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }
}
