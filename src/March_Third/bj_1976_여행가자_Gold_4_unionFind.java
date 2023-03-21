package March_Third;

import java.util.*;
import java.io.*;
public class bj_1976_여행가자_Gold_4_unionFind {

    static int[]parents;
    static int N,M;
    static String answer = "YES";

    static void make() {
        for(int i=1;i<N+1;i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {

        if(parents[a]==a) return a;

        return parents[a] = find(parents[a]);

    }

    static void union(int a,int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot!=bRoot) {
            if(aRoot < bRoot) {
                parents[bRoot] = aRoot;
            }else {
                parents[aRoot] = bRoot;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
    }
}
