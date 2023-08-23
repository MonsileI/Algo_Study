package Algorithm_fifth_week_2023_07.st;

import java.util.*;
import java.io.*;
public class st_사물인최소면적산출프로그램_Level_3 {
    static class Node {
        int i;int j;int c;

        public Node(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.c = c;
        }
    }
    static int N,K;
    static Node []map;
    static int answer;
    static boolean[]choice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Node[N];
        answer = 987654321;
        for(int d=0;d<N;d++){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken())-1;
            map[d] = new Node(i,j,c);
        }
        int[] tmp = new int[K];
        choice = new boolean[K];
        comb(0,0,0,tmp);
        System.out.println(answer);

    }
    static  void comb(int depth,int start,int result,int[]tmp){
        if(answer<=result) return;
        if(depth==K){
            answer = Math.min(answer,result);
            return;
        }
        for(int i=start;i<N;i++){
            if(!choice[map[i].c]){
                choice[map[i].c] = true;
                tmp[depth] = i;
                if(depth==1&&tmp[0] == 0&&tmp[1]==5) System.out.println(result);
                if(0<depth){
                    int minI = 1000; int minJ = 1000; int maxI = -1000; int maxJ = -1000;
                    for(int d=depth;-1<d;d--){
                        minI = Math.min(minI,map[tmp[d]].i);
                        minJ = Math.min(minJ,map[tmp[d]].j);
                        maxI = Math.max(maxI,map[tmp[d]].i);
                        maxJ = Math.max(maxJ,map[tmp[d]].j);
                    }
                    result = Math.max(result,Math.abs(maxI-minI)*Math.abs(maxJ-minJ));
                }
                comb(depth+1,i+1,result,tmp);
                choice[map[i].c] = false;
            }
        }

    }
}
