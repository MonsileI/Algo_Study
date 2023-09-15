package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_7511_소셜네트워킹어플리케이션_Gold_5 {

    static int[]parenst;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        String ansStr = "Scenario ";
        for(int t=1;t<TC+1;t++){
            sb.append(ansStr+t+":\n");
            int N = Integer.parseInt(br.readLine());
            parenst = new int[N];
            for(int i=0;i<N;i++) parenst[i] = i;
            int M = Integer.parseInt(br.readLine());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            int f = Integer.parseInt(br.readLine());
            for(int i=0;i<f;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(find(a)!=find(b)) sb.append(0+"\n");
                else sb.append(1+"\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB){
            parenst[rootB] = rootA;
        }else{
            parenst[rootA] = rootB;
        }
    }
    static int find(int num){
        if(parenst[num]==num) return num;
        return parenst[num] = find(parenst[num]);
    }
}
